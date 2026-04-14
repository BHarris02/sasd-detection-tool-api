package com.sasd.data.mapper.vcs

import com.sasd.data.client.vcs.dto.FileContentDto
import com.sasd.domain.entity.vcs.FileContent
import java.util.Base64

fun FileContentDto.toDomain() = FileContent(
    content = String(Base64.getMimeDecoder().decode(content))
)