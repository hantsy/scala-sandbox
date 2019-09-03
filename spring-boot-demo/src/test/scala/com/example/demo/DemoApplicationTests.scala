package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{Assertions, Test}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests @Autowired()(val testRestTemplate: TestRestTemplate) {

  @LocalServerPort
  val port: Int = 0

  @Test def contextLoads() = {
    val res = testRestTemplate.getForEntity(s"http://localhost:$port", classOf[Array[Post]])
    assertEquals(res.getStatusCodeValue(), 200)
    assertEquals(res.getBody().length, 2)
  }
}