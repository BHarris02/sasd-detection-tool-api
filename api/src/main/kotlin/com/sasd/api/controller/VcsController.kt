package com.sasd.api.controller

import com.sasd.api.mapper.toResponse
import com.sasd.api.model.response.vcs.GetFileContentResponse
import com.sasd.api.model.response.vcs.GetRepositoryStructureResponse
import com.sasd.domain.common.DomainResult
import com.sasd.domain.usecase.vcs.GetFileContentUseCase
import com.sasd.domain.usecase.vcs.GetRepositoryStructureUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vcs")
class VcsController(
    private val getFileContentUseCase: GetFileContentUseCase,
    private val getRepositoryStructureUseCase: GetRepositoryStructureUseCase
) {
    @GetMapping("/repository-structure")
    suspend fun getRepositoryStructure(@RequestParam repoUrl: String): List<GetRepositoryStructureResponse> {
        return when (val result = getRepositoryStructureUseCase(repoUrl)) {
            is DomainResult.Success -> result.value.map { it.toResponse() }
            is DomainResult.Failure -> throw result.error
        }
    }

    @GetMapping("/file-content")
    suspend fun getFileContent(
        @RequestParam repoUrl: String,
        @RequestParam filePath: String
    ): GetFileContentResponse {
        return when (val result = getFileContentUseCase(repoUrl, filePath)) {
            is DomainResult.Success -> GetFileContentResponse(result.value.content)
            is DomainResult.Failure -> throw result.error
        }
    }
}
