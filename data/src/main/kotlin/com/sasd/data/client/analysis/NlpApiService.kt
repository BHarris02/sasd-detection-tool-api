package com.sasd.data.client.analysis

import com.sasd.data.client.analysis.dto.NlpAnalysisDto

interface NlpApiService {
    suspend fun analyzeCommit(commitMessage: String): NlpAnalysisDto
    suspend fun analyzeIssue(issue: String): NlpAnalysisDto
    suspend fun analyzeComment(comment: String): NlpAnalysisDto
}