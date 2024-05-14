package com.kanzankazu.composecleanarchitecture.data.repository.preference

import com.kanzankazu.composecleanarchitecture.data.datasource.local.sharedpreference.source.app.AppPreferencesSource
import javax.inject.Inject

class AppPreferenceRepositoryImpl @Inject constructor(
    private val appPreferencesSource: AppPreferencesSource,
) : AppPreferenceRepository {
    override fun setFlavor(flavor: String) {
        appPreferencesSource.flavour = flavor
    }

    override fun getFlavor() = appPreferencesSource.flavour

    override fun isFlavorProduction() = appPreferencesSource.flavour.equals("release", true)
}

