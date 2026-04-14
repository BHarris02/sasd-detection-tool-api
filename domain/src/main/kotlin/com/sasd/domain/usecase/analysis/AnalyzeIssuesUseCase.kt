package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeIssuesUseCase {
    operator fun invoke(issues: List<Issue>): DomainResult<List<NlpAnalysis>>
}

internal class AnalyzeIssuesUseCaseImpl(
    private val nlpGateway: NlpGateway,
    private val vcsRepository: VcsRepository
): AnalyzeIssuesUseCase {
    override fun invoke(issues: List<Issue>): DomainResult<List<NlpAnalysis>> {
        TODO("Not yet implemented")
    }
}