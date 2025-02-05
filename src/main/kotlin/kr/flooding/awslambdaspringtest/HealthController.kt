package kr.flooding.awslambdaspringtest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping("/health")
    fun health(): ResponseEntity<HealthResponse> = ResponseEntity.ok(HealthResponse("OK"))
}