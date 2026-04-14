package com.sasd.domain.gateway

import com.sasd.domain.entity.analysis.NlpAnalysis
import com.sasd.domain.entity.vcs.CodeSnippet
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue

/**
 * Gateway interface for performing NLP sentiment analysis via an LLM.
 *
 * Exposes methods required by `:domain:` interactors. Implementations
 * are provided in the `:data:` layer.
 */
interface NlpGateway {
    /**
     * Sends a list of commits to the LLM API for sentiment analysis.
     *
     * @param commits the list of [Commit] objects to analyse.
     * @return a list of [NlpAnalysis] results, one per commit.
     */
    suspend fun analyzeCommits(commits: List<Commit>): List<NlpAnalysis>

    /**
     * Sends a list of issues to the LLM API for sentiment analysis.
     *
     * @param issues the list of [Issue] objects to analyse.
     * @return a list of [NlpAnalysis] results, one per issue.
     */
    suspend fun analyzeIssues(issues: List<Issue>): List<NlpAnalysis>

    /**
     * Sends a code snippet to the LLM API for comment sentiment analysis.
     *
     * @param sourceCode the [CodeSnippet] containing the code to analyse.
     * @return an [NlpAnalysis] result for the snippet's comments.
     */
    suspend fun analyzeCodeComments(sourceCode: CodeSnippet): NlpAnalysis

    /**
     * Sends file content to the LLM API for comment sentiment analysis.
     *
     * @param content the [FileContent] containing the file to analyse.
     * @return an [NlpAnalysis] result for the file's comments.
     */
    suspend fun analyzeFileComments(content: FileContent): NlpAnalysis
}
