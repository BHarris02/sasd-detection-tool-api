package com.sasd.domain.common

class DomainError(message: String? = null, cause: Throwable? = null): Exception(message, cause)
