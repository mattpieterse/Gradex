package com.mpieterse.gradex.core.dependency

import android.content.Context
import com.mpieterse.gradex.core.contexts.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    /**
     * Injects the [AppDatabase] instance.
     *
     * **Note:** As the DAOs within the [AppDatabase] are defined as abstract,
     * they will be automatically injected where required. Hilt understands that
     * these need to be provided, so they do not need individual inject methods.
     * 
     * @return [AppDatabase]
     */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)
}