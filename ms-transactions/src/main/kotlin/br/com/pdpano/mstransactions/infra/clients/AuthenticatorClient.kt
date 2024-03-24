package br.com.pdpano.mstransactions.infra.clients

import br.com.pdpano.mstransactions.domain.AuthenticatorGateway
import br.com.pdpano.mstransactions.domain._dto.AuthenticatorClientDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "authenticator", url = "\${ms-transactions.clients.mocky}")
interface AuthenticatorClient: AuthenticatorGateway {

    @GetMapping(value = ["\${ms-transactions.clients.authenticator}"])
    override fun authenticate(): AuthenticatorClientDTO

}