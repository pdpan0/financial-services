package br.com.pdpano.mstransactions.domain

import br.com.pdpano.mstransactions.domain._dto.NotificationClientDTO

interface NotificationGateway {
    fun notify(): NotificationClientDTO
}