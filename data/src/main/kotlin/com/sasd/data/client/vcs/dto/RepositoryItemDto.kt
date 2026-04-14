package com.sasd.data.client.vcs.dto

import kotlinx.serialization.Serializable

@Serializable
data class RepositoryItemDto(
    val name: String,
    val type: String,
    val path: String,
    val url: String,
    val children: List<RepositoryItemDto>? = null
)
