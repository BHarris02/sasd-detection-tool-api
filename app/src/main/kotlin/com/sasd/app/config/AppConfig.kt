package com.sasd.app.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "sasd")
data class AppConfig(
    // vcs
    val githubToken: String,
    val githubBaseUrl: String,
    val githubTimeout: Long,
    // nlp
    val llmProvider: String,
    val llmApiKey: String,
    val llmModel: String
)
