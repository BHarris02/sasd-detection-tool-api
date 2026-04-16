package com.sasd.data.gateway

import com.sasd.data.client.analysis.NlpApiService
import com.sasd.data.mapper.analysis.toDomain
import com.sasd.domain.common.DomainError
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.CodeSnippet
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.gateway.NlpGateway
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class NlpGatewayImpl(
    private val nlpApiService: NlpApiService
): NlpGateway {
    override suspend fun analyzeCommits(commits: List<Commit>): List<NlpAnalysis> {
        try {
            return coroutineScope {
                commits.map {
                    async {
                        nlpApiService.analyzeCommit(it.message)
                    }
                }
            }.awaitAll().map {
                it.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze commits", e)
        }
    }

    override suspend fun analyzeIssues(issues: List<Issue>): List<NlpAnalysis> {
        try {
            return coroutineScope {
                issues.map {
                    async {
                        nlpApiService.analyzeIssue("${it.title}: \n${it.description}")
                    }
                }
            }.awaitAll().map {
                it.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze issues", e)
        }
    }

    override suspend fun analyzeCodeComments(sourceCode: CodeSnippet): NlpAnalysis {
        try {
            return nlpApiService.analyzeComment(sourceCode.body).toDomain()
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze code comments", e)
        }
    }

    override suspend fun analyzeFileComments(content: FileContent): NlpAnalysis {
        try {
            return nlpApiService.analyzeComment(content.content).toDomain()
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze file comments", e)
        }
    }
}
