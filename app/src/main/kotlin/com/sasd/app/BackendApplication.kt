package com.sasd.app

import com.sasd.app.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AppConfig::class)
class BackendApplication

fun main(args: Array<String>) {
	runApplication<BackendApplication>(*args)
}
