package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeCommitsUseCase {
    operator fun invoke(commits: List<Commit>): DomainResult<List<NlpAnalysis>>
}

internal class AnalyzeCommitsUseCaseImpl(
    private val nlpGateway: NlpGateway,
    private val vcsRepository: VcsRepository
): AnalyzeCommitsUseCase {
    override fun invoke(commits: List<Commit>): DomainResult<List<NlpAnalysis>> {
        TODO("Not yet implemented")
    }
}