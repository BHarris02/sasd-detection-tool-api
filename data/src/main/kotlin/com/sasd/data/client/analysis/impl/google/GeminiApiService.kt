package com.sasd.data.client.analysis.impl.google

import com.google.genai.Client
import com.google.genai.types.Content
import com.google.genai.types.GenerateContentConfig
import com.google.genai.types.GenerateContentResponse
import com.google.genai.types.Part
import com.sasd.data.client.analysis.NLP_SYSTEM_PROMPT
import com.sasd.data.client.analysis.NlpApiService
import com.sasd.data.client.analysis.NlpArtifactType
import com.sasd.data.client.analysis.dto.NlpAnalysisDto
import kotlinx.serialization.json.Json
import java.io.Closeable

class GeminiApiService(
    private val apiToken: String,
    private val model: String
): NlpApiService, Closeable {

    private val client = Client.builder()
        .apiKey(apiToken)
        .build()

    private val config = GenerateContentConfig.builder()
        .systemInstruction(Content.fromParts(Part.fromText(NLP_SYSTEM_PROMPT)))
        .responseMimeType("application/json")
        .build()

    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun analyzeCommit(commitMessage: String): NlpAnalysisDto {
        return analyzeArtifact(commitMessage, NlpArtifactType.COMMIT.value)
    }

    override suspend fun analyzeIssue(issue: String): NlpAnalysisDto {
        return analyzeArtifact(issue, NlpArtifactType.ISSUE.value)
    }

    override suspend fun analyzeComment(comment: String): NlpAnalysisDto {
        return analyzeArtifact(comment, NlpArtifactType.COMMENT.value)
    }

    // utils

    private suspend fun analyzeArtifact(artifact: String, artifactType: String): NlpAnalysisDto {
        val prompt = "Analyze the following $artifactType for self-admitted security debt:\n\n$artifact"
        val resp: GenerateContentResponse = client.models.generateContent(
            model,
            prompt,
            config
        )
        val text = resp.text() ?: throw IllegalStateException()
        return json.decodeFromString<NlpAnalysisDto>(text)
    }

    override fun close() {
        client.close()
    }
}