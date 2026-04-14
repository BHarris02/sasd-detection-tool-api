package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.CodeSnippet
import com.sasd.domain.gateway.NlpGateway

fun interface AnalyzeCodeCommentsUseCase {
    operator fun invoke(sourceCode: CodeSnippet): DomainResult<NlpAnalysis>
}

internal class AnalyzeCodeCommentsUseCaseImpl(
    private val nlpGateway: NlpGateway
): AnalyzeCodeCommentsUseCase {
    override fun invoke(sourceCode: CodeSnippet): DomainResult<NlpAnalysis> {
        TODO("Not yet implemented")
    }
}