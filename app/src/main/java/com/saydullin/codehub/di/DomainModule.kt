package com.saydullin.codehub.di

import com.saydullin.domain.usecase.GetProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesProfileUseCase(

    ): GetProfileUseCase {
        return GetProfileUseCase()
    }

}