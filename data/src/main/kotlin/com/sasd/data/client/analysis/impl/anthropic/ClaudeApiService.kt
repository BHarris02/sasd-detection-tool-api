package com.sasd.data.client.analysis.impl.anthropic

import com.anthropic.client.okhttp.AnthropicOkHttpClient
import com.anthropic.models.messages.MessageCreateParams
import com.sasd.data.client.analysis.NLP_SYSTEM_PROMPT
import com.sasd.data.client.analysis.NlpApiService
import com.sasd.data.client.analysis.NlpArtifactType
import com.sasd.data.client.analysis.dto.NlpAnalysisDto
import kotlinx.serialization.json.Json
import java.io.Closeable

class ClaudeApiService(
    apiToken: String,
    private val model: String
): NlpApiService, Closeable {

    private val client = AnthropicOkHttpClient.builder()
        .apiKey(apiToken)
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

    private fun analyzeArtifact(artifact: String, artifactType: String): NlpAnalysisDto {
        val prompt = "Analyze the following $artifactType for self-admitted security debt:\n\n$artifact"
        val params = MessageCreateParams.builder()
            .model(model)
            .maxTokens(1024)
            .system(MessageCreateParams.System.ofString(NLP_SYSTEM_PROMPT))
            .addUserMessage(prompt)
            .build()
        val message = client.messages().create(params)
        val text = message.content().first().asText().text()
            .removePrefix("```json\n").removeSuffix("\n```").trim()
        return json.decodeFromString<NlpAnalysisDto>(text)
    }

    override fun close() {
        client.close()
    }
}