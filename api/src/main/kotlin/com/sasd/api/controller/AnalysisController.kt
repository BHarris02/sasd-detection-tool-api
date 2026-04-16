package com.sasd.api.controller

import com.sasd.api.mapper.toCodeCommentsResponse
import com.sasd.api.mapper.toCommitResponse
import com.sasd.api.mapper.toFileCommentsResponse
import com.sasd.api.mapper.toIssueResponse
import com.sasd.api.model.request.AnalyzeCodeCommentsRequest
import com.sasd.api.model.request.AnalyzeCommitsRequest
import com.sasd.api.model.request.AnalyzeFileCommentsRequest
import com.sasd.api.model.request.AnalyzeIssuesRequest
import com.sasd.api.model.request.AnalyzeRepositoryRequest
import com.sasd.api.model.response.analysis.AnalyzeCodeCommentsResponse
import com.sasd.api.model.response.analysis.AnalyzeCommitsResponse
import com.sasd.api.model.response.analysis.AnalyzeFileCommentsResponse
import com.sasd.api.model.response.analysis.AnalyzeIssuesResponse
import com.sasd.api.model.response.analysis.AnalyzeRepositoryResponse
import com.sasd.domain.common.DomainResult
import com.sasd.domain.usecase.analysis.AnalyzeCodeCommentsUseCase
import com.sasd.domain.usecase.analysis.AnalyzeCommitsUseCase
import com.sasd.domain.usecase.analysis.AnalyzeFileCommentsUseCase
import com.sasd.domain.usecase.analysis.AnalyzeIssuesUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/analysis")
class AnalysisController(
    private val analyzeCommitsUseCase: AnalyzeCommitsUseCase,
    private val analyzeIssuesUseCase: AnalyzeIssuesUseCase,
    private val analyzeCodeCommentsUseCase: AnalyzeCodeCommentsUseCase,
    private val analyzeFileCommentsUseCase: AnalyzeFileCommentsUseCase
) {
    @PostMapping("/commits")
    suspend fun analyzeCommits(@RequestBody req: AnalyzeCommitsRequest): List<AnalyzeCommitsResponse> {
        return when (val result = analyzeCommitsUseCase(req.repoUrl)) {
            is DomainResult.Success -> result.value.map { it.toCommitResponse() }
            is DomainResult.Failure -> throw result.error
        }
    }

    @PostMapping("/issues")
    suspend fun analyzeIssues(@RequestBody req: AnalyzeIssuesRequest): List<AnalyzeIssuesResponse> {
        return when (val result = analyzeIssuesUseCase(req.repoUrl)) {
            is DomainResult.Success -> result.value.map { it.toIssueResponse() }
            is DomainResult.Failure -> throw result.error
        }
    }

    @PostMapping("/code-comments")
    suspend fun analyzeCodeComments(@RequestBody req: AnalyzeCodeCommentsRequest): AnalyzeCodeCommentsResponse {
        return when (val result = analyzeCodeCommentsUseCase(req.sourceCode)) {
            is DomainResult.Success -> result.value.toCodeCommentsResponse()
            is DomainResult.Failure -> throw result.error
        }
    }

    @PostMapping("/file-comments")
    suspend fun analyzeFileComments(@RequestBody req: AnalyzeFileCommentsRequest): AnalyzeFileCommentsResponse {
        return when (val result = analyzeFileCommentsUseCase(req.repoUrl, req.filePath)) {
            is DomainResult.Success -> result.value.toFileCommentsResponse()
            is DomainResult.Failure -> throw result.error
        }
    }

    @PostMapping("/repository")
    fun analyzeRepository(@RequestBody req: AnalyzeRepositoryRequest): AnalyzeRepositoryResponse {
        throw NotImplementedError()
    }
}
