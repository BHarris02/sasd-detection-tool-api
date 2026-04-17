package com.sasd.app.di

import com.sasd.app.config.AppConfig
import com.sasd.data.client.analysis.NlpApiService
import com.sasd.data.client.analysis.impl.anthropic.ClaudeApiService
import com.sasd.data.client.analysis.impl.google.GeminiApiService
import com.sasd.data.client.vcs.VcsApiService
import com.sasd.data.client.vcs.impl.github.GitHubApiService
import com.sasd.data.gateway.NlpGatewayImpl
import com.sasd.data.repository.VcsRepositoryImpl
import com.sasd.domain.gateway.NlpGateway
import com.sasd.domain.repository.VcsRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataConfiguration(private val config: AppConfig) {

    @Bean
    fun vcsApiService(): VcsApiService = GitHubApiService(
        config.githubToken,
        config.githubBaseUrl,
        config.githubTimeout
    )

    @Bean
    fun vcsRepository(vcsApiService: VcsApiService): VcsRepository = VcsRepositoryImpl(vcsApiService)

    @Bean
    fun nlpApiService(): NlpApiService = when (config.llmProvider) {
        "google" -> GeminiApiService(config.llmApiKey, config.llmModel)
        "anthropic" -> ClaudeApiService(config.llmApiKey, config.llmModel)
        else -> throw IllegalArgumentException("Unsupported LLM provider: ${config.llmProvider}")
    }

    @Bean
    fun nlpGateway(nlpApiService: NlpApiService): NlpGateway = NlpGatewayImpl(nlpApiService)
}
