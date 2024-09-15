package com.saydullin.domain.ext

/**
 * filter from second list
 *
 * replace current list by filtered second
 *
 * @return Unit
 */
fun <T> MutableList<T>.filterFrom(list: List<T>, predicate: (T) -> Boolean) {
    for (element in list) if (predicate(element)) add(element)
}