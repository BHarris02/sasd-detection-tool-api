package com.sasd.data.client.analysis

import com.sasd.data.client.analysis.dto.NlpAnalysisDto

interface NlpApiService {
    fun analyzeCommit(commitMessage: String): NlpAnalysisDto
    fun analyzeIssue(issue: String): NlpAnalysisDto
    fun analyzeComment(comment: String): NlpAnalysisDto
}