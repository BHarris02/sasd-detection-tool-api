package com.sasd.domain.common

sealed class DomainResult<out T> {
    data class Success<T>(val value: T): DomainResult<T>()
    data class Failure(val error: DomainError): DomainResult<Nothing>()
}