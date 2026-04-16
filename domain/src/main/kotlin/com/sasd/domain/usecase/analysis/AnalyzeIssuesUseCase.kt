package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainError
import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeIssuesUseCase {
    suspend operator fun invoke(repoUrl: String): DomainResult<List<NlpAnalysis>>
}

class AnalyzeIssuesUseCaseImpl(
    private val nlpGateway: NlpGateway,
    private val vcsRepository: VcsRepository
): AnalyzeIssuesUseCase {
    override suspend fun invoke(repoUrl: String): DomainResult<List<NlpAnalysis>> {
        try {
            val issues = vcsRepository.getIssues(repoUrl)
            val filteredIssueAnalyses = nlpGateway.analyzeIssues(issues).filter { it.isSasd }
            return DomainResult.Success(filteredIssueAnalyses)
        }
        catch (e: DomainError) {
            return DomainResult.Failure(e)
        }
    }
}