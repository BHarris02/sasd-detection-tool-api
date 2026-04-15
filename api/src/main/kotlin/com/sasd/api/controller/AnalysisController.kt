package com.sasd.api.controller

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
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/analysis")
class AnalysisController {
    @PostMapping("/commits")
    fun analyzeCommits(@RequestBody req: AnalyzeCommitsRequest): AnalyzeCommitsResponse {
        throw NotImplementedError()
    }

    @PostMapping("/issues")
    fun analyzeIssues(@RequestBody req: AnalyzeIssuesRequest): AnalyzeIssuesResponse {
        throw NotImplementedError()
    }

    @PostMapping("/code-comments")
    fun analyzeCodeComments(@RequestBody req: AnalyzeCodeCommentsRequest): AnalyzeCodeCommentsResponse {
        throw NotImplementedError()
    }

    @PostMapping("/file-comments")
    fun analyzeFileComments(@RequestBody req: AnalyzeFileCommentsRequest): AnalyzeFileCommentsResponse {
        throw NotImplementedError()
    }

    @PostMapping("/repository")
    fun analyzeRepository(@RequestBody req: AnalyzeRepositoryRequest): AnalyzeRepositoryResponse {
        throw NotImplementedError()
    }
}
