package com.sasd.app.di

import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository
import com.sasd.domain.usecase.analysis.AnalyzeCodeCommentsUseCase
import com.sasd.domain.usecase.analysis.AnalyzeCodeCommentsUseCaseImpl
import com.sasd.domain.usecase.analysis.AnalyzeCommitsUseCase
import com.sasd.domain.usecase.analysis.AnalyzeCommitsUseCaseImpl
import com.sasd.domain.usecase.analysis.AnalyzeFileCommentsUseCase
import com.sasd.domain.usecase.analysis.AnalyzeFileCommentsUseCaseImpl
import com.sasd.domain.usecase.analysis.AnalyzeIssuesUseCase
import com.sasd.domain.usecase.analysis.AnalyzeIssuesUseCaseImpl
import com.sasd.domain.usecase.vcs.GetFileContentUseCase
import com.sasd.domain.usecase.vcs.GetFileContentUseCaseImpl
import com.sasd.domain.usecase.vcs.GetRepositoryStructureUseCase
import com.sasd.domain.usecase.vcs.GetRepositoryStructureUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UsecaseConfiguration {

    @Bean
    fun getFileContentUseCase(
        vcsRepository: VcsRepository
    ): GetFileContentUseCase = GetFileContentUseCaseImpl(vcsRepository)

    @Bean
    fun getRepositoryStructureUseCase(
        vcsRepository: VcsRepository
    ): GetRepositoryStructureUseCase = GetRepositoryStructureUseCaseImpl(vcsRepository)

    @Bean
    fun analyzeCommitsUseCase(
        nlpGateway: NlpGateway,
        vcsRepository: VcsRepository
    ): AnalyzeCommitsUseCase = AnalyzeCommitsUseCaseImpl(nlpGateway, vcsRepository)

    @Bean
    fun analyzeIssuesUseCase(
        nlpGateway: NlpGateway,
        vcsRepository: VcsRepository
    ): AnalyzeIssuesUseCase = AnalyzeIssuesUseCaseImpl(nlpGateway, vcsRepository)

    @Bean
    fun analyzeCodeCommentsUseCase(
        nlpGateway: NlpGateway
    ): AnalyzeCodeCommentsUseCase = AnalyzeCodeCommentsUseCaseImpl(nlpGateway)

    @Bean
    fun analyzeFileCommentsUseCase(
        nlpGateway: NlpGateway,
        vcsRepository: VcsRepository
    ): AnalyzeFileCommentsUseCase = AnalyzeFileCommentsUseCaseImpl(nlpGateway, vcsRepository)
}