package com.example.demo

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.{Assertions, DisplayName, Test}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests @Autowired()(val testRestTemplate: TestRestTemplate) {

  @LocalServerPort
  val port: Int = 0

  @DisplayName(value ="Get all posts should return 200 status code")
  @Test def getAllPosts() = {
    val res = testRestTemplate.getForEntity(s"http://localhost:$port", classOf[Array[Post]])
    assertEquals( 200, res.getStatusCodeValue())
    assertEquals(2, res.getBody().length)
  }

  @DisplayName(value ="Save post when tile is not filled should return bad request")
  @Test def saveInvalidPost() = {
    val res = testRestTemplate.postForEntity(s"http://localhost:$port", PostForm(null, null), null)
    assertEquals(400, res.getStatusCodeValue())
  }

  @DisplayName(value ="Save valid post should return 201")
  @Test def saveValidPost() = {
    val res = testRestTemplate.postForEntity(s"http://localhost:$port", PostForm("test title", "test content"), null)
    assertEquals(201, res.getStatusCodeValue())
    assertNotNull(res.getHeaders.getLocation)
  }
}