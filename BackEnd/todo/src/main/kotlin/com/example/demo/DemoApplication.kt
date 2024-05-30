package com.example.demo

import WebConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(WebConfig::class)
class DemoApplication {
	//val logger: Logger = LoggerFactory.getLogger(DemoApplication::class.java)
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
