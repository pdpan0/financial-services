package br.com.pdpano.mstransactions.infra.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient(value = "notification", url = "\${ms-transactions.clients.mocky}")
interface NotificationClient {

    @GetMapping(value = ["\${ms-transactions.clients.notification}"])
    fun notify(): String
}