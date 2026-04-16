package com.sasd.domain.entity.analysis

import com.sasd.domain.entity.vcs.CodeSnippet
import com.sasd.domain.entity.vcs.Commit
import com.sasd.domain.entity.vcs.FileContent
import com.sasd.domain.entity.vcs.Issue

sealed class AnalysisArtifact {
    data class CommitArtifact(val commit: Commit): AnalysisArtifact()
    data class IssueArtifact(val issue: Issue): AnalysisArtifact()
    data class CodeSnippetArtifact(val codeSnippet: CodeSnippet): AnalysisArtifact()
    data class FileContentArtifact(val fileContent: FileContent): AnalysisArtifact()
}
