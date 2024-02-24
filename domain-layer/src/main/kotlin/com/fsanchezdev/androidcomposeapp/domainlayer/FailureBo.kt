package com.fsanchezdev.androidcomposeapp.domainlayer

import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR

sealed class FailureBo {
    data object NoNetwork : FailureBo()
    data object Unknown : FailureBo()
    data object InputParamsError : FailureBo()
    data object NoData : FailureBo()
    data object UnAuthorizedError : FailureBo()
    data object ServerError : FailureBo()
    open class Error(val code: Int = HTTP_INTERNAL_ERROR, val message: String?) : FailureBo()
    open class ErrorResId(val code: Int = HTTP_INTERNAL_ERROR, val resId: Int) : FailureBo()
    open class SpecificFailure<T>(val error: T) : FailureBo()
}
