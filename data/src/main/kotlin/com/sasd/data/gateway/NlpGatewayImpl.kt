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

class NlpGatewayImpl(
    private val nlpApiService: NlpApiService
): NlpGateway {
    override suspend fun analyzeCommits(commits: List<Commit>): List<NlpAnalysis> {
        try {
            val analysesDtos = commits.map { commit ->
                nlpApiService.analyzeCommit(commit.message)
            }
            return analysesDtos.map { dto ->
                dto.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }

    override suspend fun analyzeIssues(issues: List<Issue>): List<NlpAnalysis> {
        try {
            val analysesDtos = issues.map { issue ->
                nlpApiService.analyzeIssue("${issue.title}: \n${issue.description}")    // TODO: parse issue labels
            }
            return analysesDtos.map { dto ->
                dto.toDomain()
            }
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }

    override suspend fun analyzeCodeComments(sourceCode: CodeSnippet): NlpAnalysis {
        try {
            val analysisDto = nlpApiService.analyzeComment(sourceCode.body)
            return analysisDto.toDomain()
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }

    override suspend fun analyzeFileComments(content: FileContent): NlpAnalysis {
        try {
            val analysisDto = nlpApiService.analyzeComment(content.content)
            return analysisDto.toDomain()
        }
        catch (e: Exception) {
            throw DomainError()
        }
    }
}
