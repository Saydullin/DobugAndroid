package com.saydullin.domain.model.response

data class MainResponse<T>(
    val date: Long,
    val request: String,
    val data: T,
    val isSuccess: Boolean
)