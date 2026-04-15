package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainError
import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeCommitsUseCase {
    suspend operator fun invoke(repoUrl: String): DomainResult<List<NlpAnalysis>>
}

internal class AnalyzeCommitsUseCaseImpl(
    private val nlpGateway: NlpGateway,
    private val vcsRepository: VcsRepository
): AnalyzeCommitsUseCase {
    override suspend fun invoke(repoUrl: String): DomainResult<List<NlpAnalysis>> {
        try {
            val commits = vcsRepository.getCommits(repoUrl)
            val commitAnalyses = nlpGateway.analyzeCommits(commits)
            return DomainResult.Success(commitAnalyses)
        }
        catch (e: DomainError) {
            return DomainResult.Failure(e)
        }
    }
}