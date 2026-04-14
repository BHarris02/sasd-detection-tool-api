package com.sasd.data.client.analysis.dto

import kotlinx.serialization.Serializable

@Serializable
data class CweMappingDto(
    val id: String,
    val name: String,
    val description: String
)
