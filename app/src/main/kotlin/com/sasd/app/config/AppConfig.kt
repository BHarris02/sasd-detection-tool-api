package com.sasd.app.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "sasd")
data class AppConfig(
    // vcs
    val githubToken: String,
    val githubBaseUrl: String,
    val githubTimeout: Long,
    // nlp
    val googleToken: String,
    val googleModel: String
)
