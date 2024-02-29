package com.saydullin.codehub.domain.util

sealed class Resource<T>(
    val data: T? = null,
    val statusType: StatusType = StatusType.SUCCESS
) {

    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(
        statusType: StatusType = StatusType.UNKNOWN_ERROR,
        data: T? = null
    ): Resource<T>(data, statusType)

}