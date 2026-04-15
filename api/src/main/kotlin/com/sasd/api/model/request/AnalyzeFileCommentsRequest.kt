package com.sasd.api.model.request

data class AnalyzeFileCommentsRequest(
    val repoUrl: String,
    val filePath: String
)
