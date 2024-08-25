package com.saydullin.domain.util.response

sealed class Resource<T>(
    val data: T? = null,
    val status: StatusType = StatusType.UNKNOWN_ERROR,
    val e: Throwable? = null,
    val message: String = "null",
) {

    fun isSuccessData(): Boolean {
        return this is Success<T> && this.data != null
    }

    fun isErrorData(): Boolean {
        return this is Error
    }

    fun getError(): Error<Unit> {
        return Error(
            e = this.e,
            status = this.status,
            message = this.message,
        )
    }

    class Success<T>(
        data: T?
    ): Resource<T>(data)

    class Error<T>(
        e: Throwable? = null,
        status: StatusType = StatusType.UNKNOWN_ERROR,
        message: String = "null",
        data: T? = null
    ): Resource<T>(data, status, e, message)

}