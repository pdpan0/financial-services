package br.com.pdpano.mstransactions.domain._response

data class ResponseErrorMessage<T>(
    val success: Boolean,
    val cause: String,
    val message: String?,
    val objects: T?
) {
    companion object {
        fun build(throwable: Throwable): ResponseErrorMessage<Nothing> {
            return ResponseErrorMessage(false, throwable.javaClass.getSimpleName(), throwable.message, null)
        }
    }
}
