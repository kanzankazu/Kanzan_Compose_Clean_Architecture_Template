package com.kanzankazu.composecleanarchitecture.data.di

import android.app.Activity
import android.content.Intent
import com.kanzankazu.composecleanarchitecture.common.extensions.getEnv
import com.kanzankazu.composecleanarchitecture.common.utils.Constant
import com.kanzankazu.composecleanarchitecture.common.utils.ContextProvider
import com.kanzankazu.composecleanarchitecture.common.utils.interceptor.AuthorizationHeaderInterceptor
import com.kanzankazu.composecleanarchitecture.common.utils.interceptor.NetworkConnectionInterceptor
import com.kanzankazu.composecleanarchitecture.common.utils.interceptor.UnauthorizedNetworkInterceptor
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(
        contextProvider: ContextProvider,
    ): OkHttpClient {
        val token = getEnv(null, "TOKEN")
        return OkHttpClient.Builder()
            .addInterceptor(AuthorizationHeaderInterceptor { token })
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            )
            .addInterceptor(
                ChuckerInterceptor.Builder(contextProvider.getContext())
                    .collector(ChuckerCollector(contextProvider.getContext(), true))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            .addNetworkInterceptor(NetworkConnectionInterceptor(contextProvider.getContext()))
            .addNetworkInterceptor(UnauthorizedNetworkInterceptor { _, _ ->
                /*if (preferencesRepositoryContract.getToken().isEmpty()) {
                    return@UnauthorizedNetworkInterceptor
                }

                //Clear data
                QiscusCore.removeDeviceToken(preferencesRepositoryContract.getFcmToken())
                if (preferencesRepositoryContract.getRoomId().isNotEmpty()) {
                    NotificationManagerCompat.from(context)
                        .cancel(preferencesRepositoryContract.getRoomId().toIntOrNull() ?: 0)
                }
                preferencesRepositoryContract.clearLoginData()
                roomRepositoryContract.deleteAllReminder()
                Freshchat.resetUser(context)

                //Delete notification
                val notificationList = roomRepositoryContract.getReminderList()
                LocalNotificationManager.deleteAllNotification(context, notificationList)*/

                //Send broadcast to finish all activity
                contextProvider.getContext().sendOrderedBroadcast(
                    Intent(Constant.UNAUTHORIZED_ACTION),
                    null,
                    null,
                    null,
                    Activity.RESULT_OK,
                    null,
                    null
                )
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val baseUrl = getEnv(null, "BASE_URL")
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}