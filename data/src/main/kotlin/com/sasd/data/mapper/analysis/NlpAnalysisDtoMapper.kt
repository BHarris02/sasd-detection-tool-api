package com.sasd.data.mapper.analysis

import com.sasd.data.client.analysis.dto.CweMappingDto
import com.sasd.data.client.analysis.dto.NlpAnalysisDto
import com.sasd.data.client.analysis.dto.SasdAnalysisDto
import com.sasd.domain.common.DomainError
import com.sasd.domain.entity.analysis.CweMapping
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.analysis.SasdAnalysis
import com.sasd.domain.entity.analysis.SasdAnalysisSeverity

fun SasdAnalysisDto.toDomain() = SasdAnalysis(
    explanation = explanation,
    severity = SasdAnalysisSeverity.entries.firstOrNull { it.value == severity } ?: throw DomainError()
)

fun CweMappingDto.toDomain() = CweMapping(
    id = id,
    name = name,
    description = description
)

fun NlpAnalysisDto.toDomain() = NlpAnalysis(
    isSasd = isSasd,
    sasdAnalysis = sasdAnalysis.toDomain(),
    cweMapping = cweMapping.toDomain()
)