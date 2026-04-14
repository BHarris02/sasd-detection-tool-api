package com.sasd.data.repository

import com.sasd.data.mapper.vcs.toDomain
import com.sasd.data.client.vcs.VcsApiService
import com.sasd.domain.common.DomainError
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.entity.vcs.RepositoryItem
import com.sasd.domain.repository.VcsRepository

class VcsRepositoryImpl(
    private val vcsApiService: VcsApiService
): VcsRepository {
    override suspend fun getCommits(repoUrl: String): List<Commit> {
        try {
            val commitDtos = vcsApiService.fetchCommits(repoUrl)
            return commitDtos.map { dto ->
                dto.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }

    override suspend fun getIssues(repoUrl: String): List<Issue> {
        try {
            val issueDtos = vcsApiService.fetchIssues(repoUrl)
            return issueDtos.map { dto ->
                dto.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }

    override suspend fun getFileContent(repoUrl: String, filePath: String): FileContent {
        try {
            val contentDto = vcsApiService.fetchFileContent(repoUrl, filePath)
            return contentDto.toDomain()
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }

    override suspend fun getRepositoryItem(repoUrl: String): List<RepositoryItem> {
        try {
            val itemDtos = vcsApiService.fetchRepositoryStructure(repoUrl)
            return itemDtos.map { dto ->
                dto.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }
}