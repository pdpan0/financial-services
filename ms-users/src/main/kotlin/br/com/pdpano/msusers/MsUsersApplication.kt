package br.com.pdpano.msusers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsTransactionsApplication

fun main(args: Array<String>) {
	runApplication<MsTransactionsApplication>(*args)
}
