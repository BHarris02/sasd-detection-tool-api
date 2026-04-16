package com.sasd.data.gateway

import com.sasd.data.client.analysis.NlpApiService
import com.sasd.data.mapper.analysis.toDomain
import com.sasd.domain.common.DomainError
import com.sasd.domain.entity.analysis.AnalysisArtifact
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
                commits.map { commit ->
                    async {
                        val dto = nlpApiService.analyzeCommit(commit.message)
                        dto.toDomain(AnalysisArtifact.CommitArtifact(commit))
                    }
                }
            }.awaitAll()
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze commits", e)
        }
    }

    override suspend fun analyzeIssues(issues: List<Issue>): List<NlpAnalysis> {
        try {
            return coroutineScope {
                issues.map { issue ->
                    async {
                        val dto = nlpApiService.analyzeIssue("${issue.title}: \n${issue.description}")
                        dto.toDomain(AnalysisArtifact.IssueArtifact(issue))
                    }
                }
            }.awaitAll()
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze issues", e)
        }
    }

    override suspend fun analyzeCodeComments(sourceCode: CodeSnippet): NlpAnalysis {
        try {
            return nlpApiService.analyzeComment(sourceCode.body).toDomain(AnalysisArtifact.CodeSnippetArtifact(sourceCode))
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze code comments", e)
        }
    }

    override suspend fun analyzeFileComments(content: FileContent): NlpAnalysis {
        try {
            return nlpApiService.analyzeComment(content.content).toDomain(AnalysisArtifact.FileContentArtifact(content))
        }
        catch (e: Exception) {
            throw DomainError("Failed to analyze file comments", e)
        }
    }
}
