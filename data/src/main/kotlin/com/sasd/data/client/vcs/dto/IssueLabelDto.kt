package com.sasd.data.client.vcs.dto

import kotlinx.serialization.Serializable

@Serializable
data class IssueLabelDto(
    val name: String,
    val description: String
)
