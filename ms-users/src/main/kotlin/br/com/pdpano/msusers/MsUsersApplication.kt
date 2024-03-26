package br.com.pdpano.msusers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MsUsersApplication

fun main(args: Array<String>) {
	runApplication<MsUsersApplication>(*args)
}
