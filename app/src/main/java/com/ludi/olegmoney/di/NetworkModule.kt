package com.ludi.olegmoney.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ludi.olegmoney.data.api.ApiHelper
import com.ludi.olegmoney.data.api.ApiHelperImpl
import com.ludi.olegmoney.data.api.ApiService
import com.ludi.olegmoney.util.Keys
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        @ApplicationContext context: Context,
    ): Retrofit {

        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Keys.baseUrl())
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl
}