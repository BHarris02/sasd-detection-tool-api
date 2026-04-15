package com.sasd.domain.usecase.analysis

import com.sasd.domain.common.DomainError
import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository

fun interface AnalyzeFileCommentsUseCase {
    suspend operator fun invoke(repoUrl: String, filePath: String): DomainResult<NlpAnalysis>
}

internal class AnalyzeFileCommentsUseCaseImpl(
    private val nlpGateway: NlpGateway,
    private val vcsRepository: VcsRepository
): AnalyzeFileCommentsUseCase {
    override suspend fun invoke(repoUrl: String, filePath: String): DomainResult<NlpAnalysis> {
        try {
            val fileContent = vcsRepository.getFileContent(repoUrl, filePath)
            val contentAnalysis = nlpGateway.analyzeFileComments(fileContent)
            return DomainResult.Success(contentAnalysis)
        }
        catch (e: DomainError) {
            return DomainResult.Failure(e)
        }
    }
}