package com.sasd.data.mapper

import com.sasd.data.client.vcs.dto.CommitDto
import com.sasd.domain.entity.vcs.Commit

fun CommitDto.toDomain() = Commit(
    message = commit.message
)