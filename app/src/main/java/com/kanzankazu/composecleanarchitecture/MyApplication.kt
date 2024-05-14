package com.kanzankazu.composecleanarchitecture

import android.app.Application
import com.kanzankazu.composecleanarchitecture.data.repository.preference.AppPreferenceRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var appPreferenceRepository: AppPreferenceRepository

    override fun onCreate() {
        super.onCreate()

        saveFlavour()
    }

    private fun saveFlavour() {
        appPreferenceRepository.setFlavor("BuildConfig.FLAVOR")
    }
}