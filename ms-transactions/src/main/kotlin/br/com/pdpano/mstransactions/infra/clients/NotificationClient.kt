package br.com.pdpano.mstransactions.infra.clients

import br.com.pdpano.mstransactions.domain.NotificationGateway
import br.com.pdpano.mstransactions.domain._dto.NotificationClientDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "notification", url = "\${ms-transactions.clients.mocky}")
interface NotificationClient: NotificationGateway {

    @GetMapping(value = ["\${ms-transactions.clients.notification}"])
    override fun notify(): NotificationClientDTO
}