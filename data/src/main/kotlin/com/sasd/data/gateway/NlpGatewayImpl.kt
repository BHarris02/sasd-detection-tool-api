package com.sasd.data.gateway

import com.sasd.data.client.analysis.NlpApiService
import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.CodeSnippet
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.gateway.NlpGateway

class NlpGatewayImpl(
    private val nlpApiService: NlpApiService
): NlpGateway {
    override fun analyzeCommits(commits: List<Commit>): List<NlpAnalysis> {
        TODO("Not yet implemented")
    }

    override fun analyzeIssues(issues: List<Issue>): List<NlpAnalysis> {
        TODO("Not yet implemented")
    }

    override fun analyzeCodeComments(sourceCode: CodeSnippet): NlpAnalysis {
        TODO("Not yet implemented")
    }

    override fun analyzeFileComments(content: FileContent): NlpAnalysis {
        TODO("Not yet implemented")
    }
}