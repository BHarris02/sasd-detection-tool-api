package com.sasd.api.model.response.vcs

data class GetRepositoryStructureResponse(
    val name: String,
    val path: String,
    val type: String,
    val children: List<GetRepositoryStructureResponse>?
)

