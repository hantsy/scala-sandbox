# Scala with Sbt 



There are some great resource to guide you to create a Sbt based Scala project:

- [SBT by example][sbt-by-example],
- [Essential SBT][essential-sbt]

Create a new folder and prepare to create a scala project with SBT.

```bash
mkdir scala-basics
cd scala-basics
touch build.sbt
```

Launch  the SBT shell.

```bash
sbt
```

When it is done, it generated some settings files for your project.

Run a `help` command to get help hints for all available commands.

You can dig into the help info of a specific command. e. g. Getting the help doc of `run` command.

```bash
sbt:scala-basics>help run
```

Using `exit` command to exit the shell. 

```bash
sbt:scala-basics>exit
```

Sbt follow the maven project structure to organize files. 

Create the corresponding folders.

```bash
$ mkdir -p src/{main,test}/scala     
$ mkdir -p src/{main,test}/resources 
```

Create a Scala file .

```scala
package example

object Hello extends App {
  println("Hello, Scala")
}
```

Compile it.

```bash
sbt:scala-basics>compile
```

Instead, you can add a `~` to compile to compile the project automatically. 

```bash
sbt:scala-basics>~compile
```

Run it.

```bash
sbt:scala-basics> run   
[info] Compiling 1 Scala source to...   //omit the file path   
[info] Done compiling.        
[info] Packaging ...                                            
[info] Done packaging.
[info] Running example.Hello   
Hello, Scala      
[success] Total time: 2 s, completed Aug 29, 2019, 2:51:09 PM  

```

Change build settings. 

```bash
 set ThisBuild / scalaVersion := "2.13.0"

```

Check if the scalaVersion is set.

```bash
sbt:scala-basics>  scalaVersion
[info] 2.13.0

```

Save the settings from  the current session into file.

```bash
sbt:scala-basics>  session save

```

Open the *build.sbt*, there is a **scalaVersion** line added. 

```scala
ThisBuild / scalaVersion := "2.13.0"

```

Change the content of *build.sbt*, and add basic description of a project.

```scala
ThisBuild / scalaVersion := "2.13.0"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )

```

 Run `reload` command to  apply the changes.

```scala
sbt:scala-basics> reload

```

Add scalatest into dependencies.

```scala
lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

```

Create a simple test under */src/test/scala*.

```scala
package com.example
import org.scalatest._

class HelloSpec extends FunSuite with DiagrammedAssertions {
  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }
}

```

Run tests.

```bash
sbt:Hello> test

```

Run incremental tests continuously.

```bash
sbt:Hello> ~testQuick

```

Use `testOnly` to run tests by speficying files.

```bash
sbt:Hello> testOnly HelloSpec

```

Create a subproject.

```bash
mkdir core
cd core
mkdir -p src/{main,test}/scala
mkdir -p src/{main,test}/resources

```

Add the following content into root *build.sbt*.

```scala
lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core"
  )

```

Use `projects` command in sbt shell to list all projects managed by the *build.sbt*.

```bash
sbt:Hello> projects
[info] In file:/D:/hantsylabs/scala-sandbox/scala-basics/
[info]   * hello
[info]     helloCore

```

Compile the subproject.

```bash
sbt:Hello> helloCore/compile

```

Switch to the subproject as current project..

```bash
sbt:Hello> project helloCore
[info] Set current project to Hello Core...

```

Show the project list again.

```bash
sbt:Hello Core> projects
[info] In file:/D:/hantsylabs/scala-sandbox/scala-basics/
[info]     hello
[info]   * helloCore

```

For the root project, set `.aggregate(helloCore)` to broadcast commands to subprojects.

Now run compile for the root project, it will also compile the subproject helloCore.

Set `.dependsOn(helloCore)` to depend on the subprojects,  and reorganize the dependencies.

```bash
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.3.1"
val playJson = "com.typesafe.play" %% "play-json" % "2.6.9"

lazy val hello = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test
  )

```

Add sbt-native-packager plugin[ ](https://www.scala-sbt.org/1.x/docs/sbt-by-example.html#Add+sbt-native-packager+plugin)

Using an editor, create `project/plugins.sbt`: 

```scala
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.4")

```

Next change build.sbt as follows to add **JavaAppPackaging**: 

```scala
lazy val hello = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test
  )

```

Reload and create a zip archive.

```bash
sbt:Hello> reload
...
[success] All package validations passed  
[info] Your package is ready in ...\hello-0.1.0-SNAPSHOT.zip            

```

Unzip  the zip. 

```bash
unzip target/universal/hello-0.1.0-SNAPSHOT.zip  
achive:  target/universal/hello-0.1.0-SNAPSHOT.zip 
inflating: hello-0.1.0-SNAPSHOT/lib/com.example.hello-0.1.0-SNAPSHOT.jar 
inflating: hello-0.1.0-SNAPSHOT/lib/com.example.hello-core-0.1.0-SNAPSHOT.jar 
inflating: hello-0.1.0-SNAPSHOT/lib/org.scala-lang.scala-library-2.12.9.jar   
...
inflating: hello-0.1.0-SNAPSHOT/bin/hello
inflating: hello-0.1.0-SNAPSHOT/bin/hello.bat

```

Run the application.

```bash
$ hello-0.1.0-SNAPSHOT/bin/hello
Hello! The weather in New York is heavy cloud.

```

Dockerize your app.

```
sbt:Hello> Docker/publishLocal
....
[info] Successfully built b6ce1b6ab2c0
[info] Successfully tagged hello:0.1.0-SNAPSHOT
[info] Built image hello:0.1.0-SNAPSHOT

```

Run the dockerized app.

```bash
$ docker run hello:0.1.0-SNAPSHOT
Hello! The weather in New York is heavy cloudy

```

[sbt-by-example]: https://www.scala-sbt.org/1.x/docs/sbt-by-example.html
[essential-sbt]: https://www.scalawilliam.com/essential-sbt/

