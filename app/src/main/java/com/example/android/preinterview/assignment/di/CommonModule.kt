package com.example.android.preinterview.assignment.di

import androidx.room.Room
import com.example.android.preinterview.assignment.App
import com.example.android.preinterview.assignment.comp.retrofit.ApiInterface
import com.example.android.preinterview.assignment.data.AppDatabase
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class CommonModule {

    @Provides
    @Singleton
    fun appDatabase(app: App): AppDatabase = Room.databaseBuilder(app, AppDatabase::class.java, "database.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun httpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun okHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(httpLoggingInterceptor)
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .build()

    @Provides
    fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.itbook.store")
        .client(okHttpClient)
        .build()

    @Provides
    fun apiInterface(retrofit: Retrofit) = retrofit.create(ApiInterface::class.java)
}
