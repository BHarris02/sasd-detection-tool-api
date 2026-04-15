package com.sasd.app

import com.sasd.app.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties(AppConfig::class)
@ComponentScan(basePackages = ["com.sasd.app", "com.sasd.api"])
class BackendApplication

fun main(args: Array<String>) {
	runApplication<BackendApplication>(*args)
}
