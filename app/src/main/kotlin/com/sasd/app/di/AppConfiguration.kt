package com.sasd.app.di

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(DataConfiguration::class, UsecaseConfiguration::class)
class AppConfiguration
