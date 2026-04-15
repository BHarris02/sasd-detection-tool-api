package com.sasd.data.client.analysis.dto

import kotlinx.serialization.Serializable

@Serializable
data class NlpAnalysisDto(
    val isSasd: Boolean,
    val sasdAnalysis: SasdAnalysisDto?,
    val cweMapping: CweMappingDto?
)
