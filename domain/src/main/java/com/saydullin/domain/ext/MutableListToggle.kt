package com.saydullin.domain.ext

import org.jetbrains.annotations.Contract

/**
 * Remove if contains.
 * Add if not contains.
 *
 * @return true - added, false - removed
 */
@Contract("removed -> false, added -> true")
fun <T> MutableList<T>.toggle(item: T): Boolean {
    if (!remove(item)) {
        add(item)

        return true
    }

    return false
}