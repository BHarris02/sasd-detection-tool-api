package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeRepositoryUseCase {
    operator fun invoke(repoUrl: String): DomainResult<List<NlpAnalysis>>
}

class AnalyzeRepositoryUseCaseImpl(
    private val vcsRepository: VcsRepository,
    private val nlpGateway: NlpGateway
): AnalyzeRepositoryUseCase {
    override fun invoke(repoUrl: String): DomainResult<List<NlpAnalysis>> {
        TODO("Not yet implemented")
    }
}