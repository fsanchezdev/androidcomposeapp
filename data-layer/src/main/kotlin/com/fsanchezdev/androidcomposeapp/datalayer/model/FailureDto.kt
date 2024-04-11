package com.fsanchezdev.androidcomposeapp.datalayer.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

/**
 * A class which models any failure coming from the 'data-layer'
 */
internal sealed class FailureDto {
    data object NoNetwork : FailureDto()
    data object Unknown : FailureDto()
    data object InputParamsError : FailureDto()
    data object NoData : FailureDto()
    class Unauthorized(val code: String?, val message: String?) : FailureDto()
    class Forbidden(val code: String?, val message: String?) : FailureDto()
    class ServerError(val code: String?, val message: String?) :
        FailureDto()
    open class Error
    @OptIn(ExperimentalSerializationApi::class)
    constructor(
        @JsonNames("code") val code: Int,
        @JsonNames("description") val message: String?
    ) : FailureDto()

    open class SpecificFailure<T>(val error: T) : FailureDto()
}
