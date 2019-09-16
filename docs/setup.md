# Set up local development environment

After getting know the basic concept of Scala language, try to practice in codes.

Scala REPL is provide a shell environment to evaluate expressions in an interactive mode.  Please refer to the [Download](https://www.scala-lang.org/download/)  documentation and start a Scala REPL shell.

- Install Scala via SDKMan!,  and execute `scala` in your terminal.
- Install Sbt, execute `sbt console` to launch Scala REPL console. 
- [Ammonite](http://ammonite.io/) is a popular Scala REPL(for Linux users). 

Besides,  [Scastie](https://scastie.scala-lang.org) and [ScalaFiddle](https://scalafiddle.io/) provide a sandbox to run Scala code snippets in a web browser.

To build a real world application, it is better to use a build tool to manage the project dependencies and build lifecycle.

- [Sbt](https://www.scala-sbt.org) is the most popular build tools for Scala projects.
- Alternatively, you can still build [Scala with Maven](https://docs.scala-lang.org/tutorials/scala-with-maven.html).
- [Gradle](https://docs.gradle.org/current/userguide/scala_plugin.html) officially supports Scala.

To work more productively, you could choose your favorite IDEs or text editors to write Scala codes.

- Intellij IDEA with Scala plugin
- Eclipse with [Scala IDE](http://www.scala-ide.org)
- VSCode with [Metals Scala Plugin](https://marketplace.visualstudio.com/items?itemName=scalameta.metals#overview)
- Apache NetBeans IDE  with nbscala plugin(Not updated to the latest NetBeans and Scala)