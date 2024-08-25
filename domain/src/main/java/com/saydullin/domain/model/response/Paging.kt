package com.saydullin.domain.model.response

data class Paging<T>(
    val pageNum: Int,
    val pageSize: Int,
    val totalPages: Int,
    val totalItems: Int,
    val availableItems: Int,
    val items: List<T>
)
