package com.sasd.domain.usecase.vcs

import com.sasd.domain.common.DomainError
import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.repository.VcsRepository

fun interface GetFileContentUseCase {
    suspend operator fun invoke(repoUrl: String, filePath: String): DomainResult<FileContent>
}

internal class GetFileContentUseCaseImpl(
    private val vcsRepository: VcsRepository
): GetFileContentUseCase {
    override suspend fun invoke(repoUrl: String, filePath: String): DomainResult<FileContent> {
        try {
            val fileContent = vcsRepository.getFileContent(repoUrl, filePath)
            return DomainResult.Success(fileContent)
        }
        catch (e: DomainError) {
            return DomainResult.Failure(e)
        }
    }
}
