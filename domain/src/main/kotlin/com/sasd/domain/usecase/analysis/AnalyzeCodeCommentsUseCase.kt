package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainError
import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.CodeSnippet
import com.sasd.domain.gateway.NlpGateway

fun interface AnalyzeCodeCommentsUseCase {
    suspend operator fun invoke(sourceCode: CodeSnippet): DomainResult<NlpAnalysis>
}

class AnalyzeCodeCommentsUseCaseImpl(
    private val nlpGateway: NlpGateway
): AnalyzeCodeCommentsUseCase {
    override suspend fun invoke(sourceCode: CodeSnippet): DomainResult<NlpAnalysis> {
        try {
            val analysis = nlpGateway.analyzeCodeComments(sourceCode)
            return DomainResult.Success(analysis)
        }
        catch (e: DomainError) {
            return DomainResult.Failure(e)
        }
    }
}