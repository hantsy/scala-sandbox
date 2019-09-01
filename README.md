# Scala Sandbox

## Getting Started  with Scala

* A great [Gist to introduce Scala](https://gist.github.com/djspiewak/cb72c41ac335a3a9b28b3307be04aa43) from [djspiewak@github](https://github.com/djspiewak)
* For those know well about Java programming,  [Scala for Java Developers](https://docs.scala-lang.org/tutorials/scala-for-java-programmers.html) is a good start point.
* The official [Tour of Scala](https://docs.scala-lang.org/tour/tour-of-scala.html) provides a guide to go through Scala language feature.
* [All About Scala](https://allaboutscala.com/) is a community driven place to centralize  Scala related resources.

Get more [Getting Started](https://docs.scala-lang.org/getting-started/index.html) resources from the official website.

## Set up local development environment

After getting know the basic concept of Scala language, try to practice in codes.

Scala REPL is provide a shell environment to evaluate expressions in an interactive mode.  Please refer to the [Download](https://www.scala-lang.org/download/)  documentation and start a Scala REPL shell.

* Install Scala via SDKMan!,  and execute `scala` in your terminal.
* Install Sbt, execute `sbt console` to launch Scala REPL console. 
* [Ammonite](http://ammonite.io/) is a popular Scala REPL(for Linux users). 

Besides,  [Scastie](https://scastie.scala-lang.org) and [ScalaFiddle](https://scalafiddle.io/) provide a sandbox to run Scala code snippets in a web browser.

To build a real world application, it is better to use a build tool to manage the project dependencies and build lifecycle.

*  [Sbt](https://www.scala-sbt.org) is the most popular build tools for Scala projects.
*  Alternatively, you can still build [Scala with Maven](https://docs.scala-lang.org/tutorials/scala-with-maven.html).
*  [Gradle](https://docs.gradle.org/current/userguide/scala_plugin.html) officially supports Scala.

To work more productively, you could choose your favorite IDEs or text editors to write Scala codes.

* Intellij IDEA with Scala plugin
* Eclipse with [Scala IDE](http://www.scala-ide.org)
* VSCode with [Metals Scala Plugin](https://marketplace.visualstudio.com/items?itemName=scalameta.metals#overview)
* Apache NetBeans IDE  with nbscala plugin(Not updated to the latest NetBeans and Scala)

## Get Your Feet Wet

I've already installed a copy of  the latest Scala from SDKMan!. I am using Cygwin under Windows 10.

Start up a Scala REPL console by typing `scala` in your terminal.  

```bash
$ scala
Welcome to Scala 2.13.0 (OpenJDK 64-Bit Server VM, Java 11.0.4).
Type in expressions for evaluation. Or try :help.
```

Type `:help` to get the help info of all available commands.

### Hello Scala 

Like the first program in all languages, let's say hello to Scala.

```bash
scala> "Hello Scala!"
res0: String = Hello Scala!
```

It assigned the returned "Hello Scala!" to  `res0` which is an immutable value .  `res0` can be referred in the next steps.

```bash
scala> val hello=res0
hello: String = Hello Scala!
```



```bash
scala> println("Hello Scala!")
Hello Scala! 
```

`println` does not return a value.

### Values and Variables

Immutable values can **NOT** be reassigned.

```bash
scala> val hello:String="Hello"
hello: String = Hello

scala> hello="Hello 2"
            ^
       error: reassignment to val
```

Variables can be mutated. 

```bash
scala> var varHello:String="Hello"
varHello: String = Hello

scala> varHello="Hello2"
mutated varHello
```

Type declaration can be ignored. 

```bash
scala> val s="Hello"
s: String = Hello

scala> var s2="Hello"
s2: String = Hello
```

### Numeric Types

There are several numeric types provided in Salca: Byte, Short, Int, Long, Float, Double.

Byte:

```bash
scala> val b:Byte=125
b: Byte = 125

scala> Byte.MinValue
res1: Byte = -128

scala> Byte.MaxValue
res2: Byte = 127
```

Short:

```bash
scala> val s:Short=125
s: Short = 125

scala> Short.MinValue
res1: Short = -32768

scala> Short.MaxValue
res2: Short = 32767
```

Int:

```bash
scala> val i:Int=125
i: Int = 125

scala> Int.MinValue
res3: Int = -2147483648

scala> Int.MaxValue
res4: Int = 2147483647
```

Long:

```bash
scala> val l:Long=125
l: Long = 125

scala> Long.MinValue
res5: Long = -9223372036854775808

scala> Long.MaxValue
res6: Long = 9223372036854775807

```

Float:

```bash
scala> val f:Float=2.0
                   ^
       error: type mismatch;
        found   : Double(2.0)
        required: Float

scala> val f:Float=2.0f
f: Float = 2.0

scala> val f:Float=2
f: Float = 2.0

scala> Float.MinValue
res1: Float = -3.4028235E38

scala> Float.MaxValue
res2: Float = 3.4028235E38

```

Double :

```bash
scala> val d:Double=2.0
d: Double = 2.0

scala> Double.MinValue
res3: Double = -1.7976931348623157E308

scala> Double.MaxValue
res4: Double = 1.7976931348623157E308
```

Implicit types.

```bash
scala> val i=125
i: Int = 125

scala> val l=125L
l: Long = 125

scala> val f=125f
f: Float = 125.0

scala> val d=125D
d: Double = 125.0
```

Conversions between numeric types.

```bash
scala> val b:Byte=125
b: Byte = 125

scala> val i:Int=b
i: Int = 125

scala> val l:Long=b
l: Long = 125

scala> val f:Float=b
f: Float = 125.0

scala> val f:Double=b
f: Double = 125.0
```
A Byte type is safe to convert other types, but inverse it is different.

```bash
scala> val l:Long=125
l: Long = 125

scala> val b:Byte=l
                  ^
       error: type mismatch;
        found   : Long
        required: Byte

scala> val b:Byte=l.toByte
b: Byte = 125

scala> val i:Int=l
                 ^
       error: type mismatch;
        found   : Long
        required: Int

scala> val i:Int=l.toInt
i: Int = 125

scala> val f:Float=l
f: Float = 125.0

scala> val d:Double=l
d: Double = 125.0
```

Another example to convert Double to others.

```bash
scala> val d:Double=3.141596
d: Double = 3.141596

scala> val f:Float=d
                   ^
       error: type mismatch;
        found   : Double
        required: Float

scala> val f:Float=d.toFloat
f: Float = 3.141596

scala> val l:Long=d
                  ^
       error: type mismatch;
        found   : Double
        required: Long

scala> val l:Long=d.toLong
l: Long = 3
```

### Chars and Strings

Char:

```bash
scala> val c:Char='A'
c: Char = A
```

Like Java, a Char can be converted to Int or from Int safely. 

```bash
scala> val i:Int=c
i: Int = 65

scala> val i:Int='A'+23
i: Int = 88

scala> val c:Char='A'+23
c: Char = X
```

String:

```bash
scala> val s="Hello, Scala!"
s: String = Hello, Scala!

scala> s.length
res4: Int = 13

scala> s.charAt(0)
res6: Char = H

scala> s(0)
res7: Char = H

scala> s.replaceAll(",", " ")
res10: String = Hello  Scala!

scala> s.toUpperCase
res14: String = HELLO, SCALA!

scala> s.reverse
res20: String = !alacS ,olleH

scala> s.flatMap(s=>s"$s ")
res29: String = "H e l l o ,   S c a l a ! "

scala> s.startsWith("H")
res31: Boolean = true

scala> s.startsWith("A")
res32: Boolean = false

scala> s.endsWith("A")
res33: Boolean = false

scala> s.endsWith("!")
res34: Boolean = true

scala> s.contains("A")
res35: Boolean = false

scala> s.contains("a")
res36: Boolean = true

```

String interpolation, 

```bash
scala> val name="Scala"
name: String = Scala

scala> s"Hello, $name"
res37: String = Hello, Scala

scala> f"Hello,$name%10s"
res44: String = Hello,     Scala
```

### Functions and Methods







#### Higher order functions

Higher order functions take other functions as parameters or return a function as
a result.



## Scala with Sbt 



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

