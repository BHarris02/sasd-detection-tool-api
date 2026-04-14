package com.sasd.domain.entity.vcs

data class Issue(
    val title: String,
    val description: String,
    val labels: List<IssueLabel>
)
