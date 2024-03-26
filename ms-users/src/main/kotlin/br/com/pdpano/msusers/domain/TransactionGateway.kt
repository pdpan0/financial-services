package br.com.pdpano.msusers.domain

import br.com.pdpano.msusers.domain._response.ResponseMessage

interface TransactionGateway {
    fun commitTransaction(idTransaction: Long): ResponseMessage<Nothing>
}