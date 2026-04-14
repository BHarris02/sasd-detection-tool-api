package com.sasd.domain.usecase.vcs

import com.sasd.domain.entity.vcs.RepositoryItem
import com.sasd.domain.repository.VcsRepository

fun interface GetRepositoryStructureUseCase {
    operator fun invoke(repoUrl: String): Result<List<RepositoryItem>>
}

internal class GetRepositoryStructureUseCaseImpl(
    private val vcsRepository: VcsRepository
): GetRepositoryStructureUseCase {
    override fun invoke(repoUrl: String): Result<List<RepositoryItem>> {
        TODO("Not yet implemented")
    }
}
