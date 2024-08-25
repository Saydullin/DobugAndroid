package com.saydullin.domain.ext

fun String.truncate(maxLength: Int, ellipsis: String = "..."): String {
    return if (this.length <= maxLength) this
    else this.substring(0, maxLength - ellipsis.length) + ellipsis
}