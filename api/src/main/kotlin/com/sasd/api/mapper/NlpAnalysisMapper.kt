package com.sasd.api.mapper

import com.sasd.api.model.response.analysis.AnalyzeCodeCommentsResponse
import com.sasd.api.model.response.analysis.AnalyzeCommitsResponse
import com.sasd.api.model.response.analysis.AnalyzeFileCommentsResponse
import com.sasd.api.model.response.analysis.AnalyzeIssuesResponse
import com.sasd.domain.entity.analysis.AnalysisArtifact
import com.sasd.domain.entity.analysis.NlpAnalysis

private inline fun <T> NlpAnalysis.toResponse(
    factory: (String, Boolean, String?, String?, String?, String?, String?) -> T,
    artifactText: String
): T = factory(
    artifactText,
    isSasd,
    sasdAnalysis?.explanation,
    sasdAnalysis?.severity?.name,
    cweMapping?.id,
    cweMapping?.name,
    cweMapping?.description
)

fun NlpAnalysis.toCommitResponse() = toResponse(
    ::AnalyzeCommitsResponse,
    (artifact as AnalysisArtifact.CommitArtifact).commit.message
)

fun NlpAnalysis.toIssueResponse(): AnalyzeIssuesResponse {
    val issue = (artifact as AnalysisArtifact.IssueArtifact).issue
    return toResponse(::AnalyzeIssuesResponse, "${issue.title}: \n\n${issue.description}")
}

fun NlpAnalysis.toCodeCommentsResponse() = toResponse(
    ::AnalyzeCodeCommentsResponse,
    (artifact as AnalysisArtifact.CodeSnippetArtifact).codeSnippet.body
)

fun NlpAnalysis.toFileCommentsResponse() = toResponse(
    ::AnalyzeFileCommentsResponse,
    (artifact as AnalysisArtifact.FileContentArtifact).fileContent.content
)
