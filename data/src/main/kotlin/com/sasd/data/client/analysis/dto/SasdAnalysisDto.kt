package com.sasd.data.client.analysis.dto

import kotlinx.serialization.Serializable

@Serializable
data class SasdAnalysisDto(
    val explanation: String,
    val severity: String
)
