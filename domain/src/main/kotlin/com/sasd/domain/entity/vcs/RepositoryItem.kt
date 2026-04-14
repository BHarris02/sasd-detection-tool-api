package com.sasd.domain.entity.vcs

data class RepositoryItem(
    val name: String,
    val path: String,
    val type: RepositoryItemType,
    val children: List<RepositoryItem>
)
