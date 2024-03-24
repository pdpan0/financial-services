package br.com.pdpano.mstransactions.domain

import br.com.pdpano.mstransactions.domain._dto.AuthenticatorClientDTO

interface AuthenticatorGateway {
    fun authenticate(): AuthenticatorClientDTO
}