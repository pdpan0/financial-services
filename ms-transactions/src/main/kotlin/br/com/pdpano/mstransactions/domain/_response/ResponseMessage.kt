package br.com.pdpano.mstransactions.domain._response

data class ResponseMessage<T>(val success: Boolean, val result: T) {
    companion object {
        fun <T> build(result: T): ResponseMessage<T> {
            return ResponseMessage(true, result)
        }
    }
}