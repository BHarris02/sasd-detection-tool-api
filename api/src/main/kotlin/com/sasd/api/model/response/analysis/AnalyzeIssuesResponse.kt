package com.sasd.api.model.response.analysis

data class AnalyzeIssuesResponse(
    val issue: String,
    val isSasd: Boolean,
    val explanation: String?,
    val severity: String?,
    val cweId: String?,
    val cweName: String?,
    val cweDescription: String?
)
