package com.kanzankazu.composecleanarchitecture.data.extensions

import com.kanzankazu.composecleanarchitecture.common.model.DataModel
import com.kanzankazu.composecleanarchitecture.common.utils.Resource
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

suspend fun <T : DataModel> handleAPICall(
    apiCall: suspend () -> Response<T>,
): Resource<T> {
    return try {
        apiCall.invoke().handleAPIResponse()
    } catch (e: Exception) {
        e.printStackTrace()
        return when (e) {
            is UnknownHostException -> Resource.Failure(IOException().toString())
            else -> Resource.Failure(IOException().toString())
        }
    }
}

private fun <T : DataModel> Response<T>.handleAPIResponse(): Resource<T> {
    val responseBody = body() as T
    if (isSuccess()) return Resource.Success(responseBody)
    return Resource.Failure(
        IOException().toString()
    )
}

private fun <T : DataModel> Response<T>.isSuccess(): Boolean = isSuccessful