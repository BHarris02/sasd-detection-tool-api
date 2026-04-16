package com.sasd.api.mapper

import com.sasd.api.model.response.analysis.AnalyzeCodeCommentsResponse
import com.sasd.api.model.response.analysis.AnalyzeCommitsResponse
import com.sasd.api.model.response.analysis.AnalyzeFileCommentsResponse
import com.sasd.api.model.response.analysis.AnalyzeIssuesResponse
import com.sasd.domain.entity.analysis.NlpAnalysis

private inline fun <T> NlpAnalysis.toResponse(
    factory: (Boolean, String?, String?, String?, String?, String?) -> T
): T = factory(
    isSasd,
    sasdAnalysis?.explanation,
    sasdAnalysis?.severity?.value,
    cweMapping?.id,
    cweMapping?.name,
    cweMapping?.description
)

fun NlpAnalysis.toCommitResponse() = toResponse(::AnalyzeCommitsResponse)

fun NlpAnalysis.toIssueResponse() = toResponse(::AnalyzeIssuesResponse)

fun NlpAnalysis.toCodeCommentsResponse() = toResponse(::AnalyzeCodeCommentsResponse)

fun NlpAnalysis.toFileCommentsResponse() = toResponse(::AnalyzeFileCommentsResponse)
