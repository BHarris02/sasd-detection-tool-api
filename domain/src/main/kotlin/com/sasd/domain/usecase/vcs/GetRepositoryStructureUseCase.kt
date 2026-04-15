package com.sasd.domain.usecase.vcs

import com.sasd.domain.common.DomainError
import com.sasd.domain.common.DomainResult
import com.sasd.domain.entity.vcs.RepositoryItem
import com.sasd.domain.repository.VcsRepository

fun interface GetRepositoryStructureUseCase {
    suspend operator fun invoke(repoUrl: String): DomainResult<List<RepositoryItem>>
}

internal class GetRepositoryStructureUseCaseImpl(
    private val vcsRepository: VcsRepository
): GetRepositoryStructureUseCase {
    override suspend fun invoke(repoUrl: String): DomainResult<List<RepositoryItem>> {
        try {
            val structure = vcsRepository.getRepositoryItem(repoUrl)
            return DomainResult.Success(structure)
        }
        catch (e: DomainError) {
            return DomainResult.Failure(e)
        }
    }
}
