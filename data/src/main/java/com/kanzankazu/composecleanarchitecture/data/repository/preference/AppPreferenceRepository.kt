package com.kanzankazu.composecleanarchitecture.data.repository.preference

interface AppPreferenceRepository {
    fun setFlavor(flavor: String)
    fun getFlavor(): String
    fun isFlavorProduction(): Boolean
}