package com.kanzankazu.composecleanarchitecture.common.utils.uistate

fun initUiStateDefault() = UiState.Default
fun initUiStateLoading() = UiState.Loading
fun initUiStateEmpty() = UiState.Empty
fun <T> T.toUiStateSuccess() = UiState.Success(this)
fun String.toUiStateError(errorMessage: String = "") = UiState.Error(errorMessage.ifEmpty { this })