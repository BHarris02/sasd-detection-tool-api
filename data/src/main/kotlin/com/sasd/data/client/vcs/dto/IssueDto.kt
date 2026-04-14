package com.sasd.data.client.vcs.dto

import kotlinx.serialization.Serializable

@Serializable
data class IssueDto(
    val title: String,
    val body: String?,
    val labels: List<IssueLabelDto>?
)
