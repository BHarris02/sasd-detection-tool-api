package com.sasd.data.client.mapper

import com.sasd.data.client.vcs.dto.IssueDto
import com.sasd.data.client.vcs.dto.IssueLabelDto
import com.sasd.domain.entity.vcs.Issue
import com.sasd.domain.entity.vcs.IssueLabel

fun IssueLabelDto.toDomain() = IssueLabel(
    name = name,
    description = description ?: ""
)

fun IssueDto.toDomain() = Issue(
    title = title,
    description = body ?: "",
    labels = labels?.map { dto ->
        dto.toDomain()
    } ?: emptyList()
)