package com.syncoders.domain.utills

/**
 * A wrapper for handling failing requests
 * */
sealed class ResultState<T>(val data: T? = null, val message: String? = null, val throwable: Throwable? = null) {
    class Success<T>(data: T? = null, message: String) : ResultState<T>(data, message)
    class Failure<T>(throwable: Throwable? = null, message: String) : ResultState<T>(null, message, throwable)
}