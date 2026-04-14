package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeFileCommentsUseCase {
    operator fun invoke(content: FileContent): DomainResult<NlpAnalysis>
}

internal class AnalyzeFileCommentsUseCaseImpl(
    private val nlpGateway: NlpGateway,
    private val vcsRepository: VcsRepository
): AnalyzeFileCommentsUseCase {
    override fun invoke(content: FileContent): DomainResult<NlpAnalysis> {
        TODO("Not yet implemented")
    }
}