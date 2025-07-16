package com.mpieterse.gradex.core.dependency

import com.google.firebase.auth.FirebaseAuth
import com.mpieterse.gradex.core.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()


    @Provides
    @Singleton
    fun provideAuthService(firebaseAuth: FirebaseAuth): AuthService = AuthService(firebaseAuth)
}