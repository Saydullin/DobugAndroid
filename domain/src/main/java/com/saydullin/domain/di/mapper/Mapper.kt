package com.saydullin.domain.di.mapper

interface Mapper<T, E> {

    fun map(from: T): E

}