package com.sasd.api.mapper

import com.sasd.api.model.response.vcs.GetRepositoryStructureResponse
import com.sasd.domain.entity.vcs.RepositoryItem

fun RepositoryItem.toResponse(): GetRepositoryStructureResponse =
    GetRepositoryStructureResponse(
        name = name,
        path = path,
        type = type.name,
        children = children?.map { it.toResponse() } ?: emptyList()
    )
