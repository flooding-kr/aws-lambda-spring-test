package kr.flooding.awslambdaspringtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AwsLambdaSpringTestApplication

fun main(args: Array<String>) {
    runApplication<AwsLambdaSpringTestApplication>(*args)
}
