package br.com.pdpano.mstransactions.infra.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "authenticator", url = "\${ms-transactions.clients.mocky}")
interface AuthenticatorClient {

    @GetMapping(value = ["\${ms-transactions.clients.authenticator}"])
    fun authenticate(): String
}