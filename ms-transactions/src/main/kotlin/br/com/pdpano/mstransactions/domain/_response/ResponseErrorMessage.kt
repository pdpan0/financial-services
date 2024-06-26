package br.com.pdpano.mstransactions.domain._response

data class ResponseErrorMessage<T>(
    val success: Boolean,
    val cause: String,
    val message: String?,
    val objects: T?
) {
    companion object {
        fun <T> build(throwable: Throwable, objects: T): ResponseErrorMessage<T> {
            return ResponseErrorMessage(false, throwable.javaClass.getSimpleName(), throwable.message, objects)
        }

        fun build(throwable: Throwable): ResponseErrorMessage<Nothing> {
            return ResponseErrorMessage(false, throwable.javaClass.getSimpleName(), throwable.message, null)
        }
    }
}
