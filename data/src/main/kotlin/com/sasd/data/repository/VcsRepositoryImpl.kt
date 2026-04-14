package com.sasd.data.repository

import com.sasd.data.client.vcs.VcsApiService
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.entity.vcs.RepositoryItem
import com.sasd.domain.repository.VcsRepository

class VcsRepositoryImpl(
    private val vcsApiService: VcsApiService
): VcsRepository {
    override fun getCommits(repoUrl: String): List<Commit> {
        TODO("Not yet implemented")
    }

    override fun getIssues(repoUrl: String): List<Issue> {
        TODO("Not yet implemented")
    }

    override fun getFileContent(
        repoUrl: String,
        filePath: String
    ): FileContent {
        TODO("Not yet implemented")
    }

    override fun getRepositoryItem(repoUrl: String): List<RepositoryItem> {
        TODO("Not yet implemented")
    }
}