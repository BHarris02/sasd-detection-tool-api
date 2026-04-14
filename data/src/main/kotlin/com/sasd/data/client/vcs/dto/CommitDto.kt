package com.sasd.data.client.vcs.dto

import kotlinx.serialization.Serializable

@Serializable
data class CommitDto(
    val commit: Detail
) {
    @Serializable
    data class Detail(
        val message: String
    )
}
