package com.example.demo

import java.time.LocalDateTime

import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}
import javax.validation.Valid
import javax.validation.constraints.{NotEmpty, NotNull}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{ApplicationArguments, ApplicationRunner, SpringApplication}
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity._
import org.springframework.stereotype.Component
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import scala.annotation.meta.field
import scala.beans.BeanProperty

object DemoApplication extends App {
  SpringApplication.run(classOf[BootConfig])
}

@SpringBootApplication
class BootConfig()

@Component
class AppInitializer @Autowired()(val posts: PostRepository) extends ApplicationRunner {
  override def run(args: ApplicationArguments): Unit = {
    val _data = List(Post(title = "first post", content = "content of first post"), Post(title = "second post", content = "content of second post"))
    //1. use for to save one by one.
    //_data.foreach(d => posts.save(d))

    //2. convert to java.util.List
    import scala.jdk.CollectionConverters._
    posts.saveAll(_data.asJava)
    posts.findAll().toArray.foreach(d => println(s"post: $d"))
  }
}

@RestController
class PostController @Autowired()(val posts: PostRepository) {
  @GetMapping
  def all() = ok(posts.findAll())

  @PostMapping
  def save(@RequestBody @Valid form: PostForm, errors: BindingResult) = errors.hasErrors match {
    case true => {
      badRequest().build()
    }
    case _ => {
      val data = Post(title = form.title, content = form.content)
      val saved = posts.save(data)
      created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(saved.id).toUri).build()
    }
  }

  @GetMapping(value = Array("/{id}"))
  def get(@PathVariable id: Long) = ok(posts.findById(id))
}

// see https://github.com/bijukunjummen/spring-boot-scala-web
//case class
case class PostForm(@(NotNull@field) @(NotEmpty@field) @BeanProperty title: String, @BeanProperty content: String)

//class PostForm {
//
//  @NotNull
//  @NotEmpty
//  @BeanProperty var title: String = _
//  @BeanProperty var content: String = _
//}

trait PostRepository extends JpaRepository[Post, Long]

@Entity
case class Post(
                 @BeanProperty var title: String,
                 @BeanProperty var content: String,
                 @BeanProperty createdOn: LocalDateTime = LocalDateTime.now()
               ) {
  def this() {
    this(null, null, null)
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty var id: Long = _

  override def toString: String = s"Post[id:$id, title:$title, content:$content, createdOn:$createdOn]"
}