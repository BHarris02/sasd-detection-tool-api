package com.sasd.api.controller

import com.sasd.api.model.response.vcs.GetFileContentResponse
import com.sasd.api.model.response.vcs.GetRepositoryStructureResponse
import com.sasd.domain.common.DomainResult
import com.sasd.domain.usecase.vcs.GetFileContentUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vcs")
class VcsController(
    private val getFileContentUseCase: GetFileContentUseCase
) {
    @GetMapping("/repository-structure")
    fun getRepositoryStructure(@RequestParam repoUrl: String): GetRepositoryStructureResponse {
        throw NotImplementedError()
    }

    @GetMapping("/file-content")
    suspend fun getFileContent(
        @RequestParam repoUrl: String,
        @RequestParam filePath: String
    ): GetFileContentResponse {
        val result = getFileContentUseCase(repoUrl, filePath)
        return when (result) {
            is DomainResult.Success -> GetFileContentResponse(result.value.content)
            is DomainResult.Failure -> throw result.error
        }
    }
}
