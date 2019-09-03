package com.example.demo

import java.time.LocalDateTime

import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{ApplicationArguments, ApplicationRunner, SpringApplication}
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity._
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RestController}

import scala.beans.BeanProperty

object DemoApplication extends App {
  SpringApplication.run(classOf[BootConfig])
}

@SpringBootApplication
class BootConfig()

@Component
class AppInitializer @Autowired()(val posts: PostRepository) extends ApplicationRunner {
  override def run(args: ApplicationArguments): Unit = {
    val _data = List(Post("first post", "content of first post"), Post("second post", "content of second post"))
    _data.foreach(d => posts.save(d))
    posts.findAll().toArray().foreach(d => println(s"post: $d"))
  }
}

@RestController
class PostController @Autowired()(val posts: PostRepository) {
  @GetMapping
  def all() = ok(posts.findAll())

  @GetMapping(value = Array("/{id}"))
  def get(@PathVariable id: Long) = ok(posts.findById(id))
}

trait PostRepository extends JpaRepository[Post, Long]

@Entity
case class Post(@BeanProperty title: String, @BeanProperty var content: String) {
  def this() {
    this(null, null)
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  val createdOn: LocalDateTime = LocalDateTime.now()

  override def toString: String = s"Post[id:$id, title:$title, content:$content, createdOn:$createdOn]"
}