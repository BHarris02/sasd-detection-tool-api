package com.sasd.data.client.vcs

import com.sasd.data.client.vcs.dto.CommitDto
import com.sasd.data.client.vcs.dto.FileContentDto
import com.sasd.data.client.vcs.dto.IssueDto
import com.sasd.data.client.vcs.dto.RepositoryItemDto

/**
 * Interface that exposes the required methods for concrete `VcsApiService` classes.
 */
interface VcsApiService {
    /**
     * Fetch `CommitDto` from remote data source.
     */
    suspend fun fetchCommits(repoUrl: String): List<CommitDto>

    /**
     * Fetch `IssueDto` from remote data source.
     */
    suspend fun fetchIssues(repoUrl: String): List<IssueDto>

    /**
     * Fetch `FileContent` from remote data source.
     */
    suspend fun fetchFileContent(repoUrl: String, filePath: String): FileContentDto

    /**
     * Fetch `RepositoryItemDto` from remote data source.
     */
    suspend fun fetchRepositoryStructure(repoUrl: String): List<RepositoryItemDto>
}
