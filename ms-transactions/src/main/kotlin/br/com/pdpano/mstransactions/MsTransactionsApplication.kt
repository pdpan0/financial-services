package br.com.pdpano.mstransactions

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MsTransactionsApplication

fun main(args: Array<String>) {
	runApplication<MsTransactionsApplication>(*args)
}
