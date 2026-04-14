package com.sasd.domain.usecase.vcs

import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.repository.VcsRepository

fun interface GetFileContentUseCase {
    operator fun invoke(repoUrl: String, filePath: String): DomainResult<FileContent>
}

internal class GetFileContentUseCaseImpl(
    private val vcsRepository: VcsRepository
): GetFileContentUseCase {
    override fun invoke(repoUrl: String, filePath: String): DomainResult<FileContent> {
        TODO("Not yet implemented")
    }
}
