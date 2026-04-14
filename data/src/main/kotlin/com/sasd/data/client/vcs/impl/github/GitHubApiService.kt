package com.sasd.data.client.vcs.impl.github

import com.sasd.data.client.vcs.VcsApiService
import com.sasd.data.client.vcs.dto.CommitDto
import com.sasd.data.client.vcs.dto.FileContentDto
import com.sasd.data.client.vcs.dto.IssueDto
import com.sasd.data.client.vcs.dto.RepositoryItemDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class GitHubApiService(
    private val apiToken: String,
    private val baseUrl: String,
    private val timeout: Long
): VcsApiService {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = timeout
        }
        defaultRequest {
            url(baseUrl)
            header("Authorization", "Bearer $apiToken")
            header("Accept", "application/vnd.github+json")
        }
    }

    override suspend fun fetchCommits(repoUrl: String): List<CommitDto> {
        return client.get("/repos/$repoUrl/commits").body()
    }

    override suspend fun fetchIssues(repoUrl: String): List<IssueDto> {
        return client.get("/repos/$repoUrl/issues").body()
    }

    override suspend fun fetchFileContent(repoUrl: String, filePath: String): FileContentDto {
        return client.get("/repos/$repoUrl/contents/$filePath").body()
    }

    override suspend fun fetchRepositoryStructure(repoUrl: String): List<RepositoryItemDto> {
        return client.get("/repos/$repoUrl/contents").body()
    }
}
