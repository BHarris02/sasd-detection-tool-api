package com.sasd.data.client.mapper

import com.sasd.data.client.vcs.dto.RepositoryItemDto
import com.sasd.domain.common.DomainError
import com.sasd.domain.entity.vcs.RepositoryItem
import com.sasd.domain.entity.vcs.RepositoryItemType

fun RepositoryItemDto.toDomain() = RepositoryItem(
    name = name,
    path = path,
    type = RepositoryItemType.entries.firstOrNull { it.value == type } ?: throw DomainError(),
    children = null
)