package com.sasd.domain.repository

import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.entity.vcs.RepositoryItem

/**
 * Repository interface for accessing version control system (VCS) data.
 *
 * Exposes methods required by `:domain:` interactors. Implementations
 * are provided in the `:data:` layer.
 */
interface VcsRepository {
    /**
     * Retrieves the commit history for a given repository.
     *
     * @param repoUrl the URL of the remote repository.
     * @return a list of [Commit] objects parsed from the remote data source.
     */
    suspend fun getCommits(repoUrl: String): List<Commit>

    /**
     * Retrieves all issues for a given repository.
     *
     * @param repoUrl the URL of the remote repository.
     * @return a list of [Issue] objects parsed from the remote data source.
     */
    suspend fun getIssues(repoUrl: String): List<Issue>

    /**
     * Retrieves the content of a specific file in a repository.
     *
     * @param repoUrl the URL of the remote repository.
     * @param filePath the path to the file within the repository.
     * @return a [FileContent] object containing the file's content.
     */
    suspend fun getFileContent(repoUrl: String, filePath: String): FileContent

    /**
     * Retrieves the top-level items (files and directories) of a repository.
     *
     * @param repoUrl the URL of the remote repository.
     * @return a list of [RepositoryItem] objects representing the repository contents.
     */
    suspend fun getRepositoryItem(repoUrl: String): List<RepositoryItem>
}
