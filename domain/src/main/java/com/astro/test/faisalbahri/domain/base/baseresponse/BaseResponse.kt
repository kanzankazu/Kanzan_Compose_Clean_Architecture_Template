package com.astro.test.faisalbahri.domain.base.baseresponse

sealed interface BaseResponse<out T> {
    object Loading : BaseResponse<Nothing>
    object Empty : BaseResponse<Nothing>
    open class Error(open val message: String) : BaseResponse<Nothing>
    class Success<T>(val data: T) : BaseResponse<T>
}
