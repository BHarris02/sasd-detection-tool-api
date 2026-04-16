package com.sasd.domain.entity.analysis

data class NlpAnalysis(
    val artifact: AnalysisArtifact,
    val isSasd: Boolean,
    val sasdAnalysis: SasdAnalysis?,
    val cweMapping: CweMapping?
)
