# Get Your Feet Wet

I've already installed a copy of  the latest Scala from SDKMan!. I am using Cygwin under Windows 10.

Start up a Scala REPL console by typing `scala` in your terminal.  

```bash
$ scala
Welcome to Scala 2.13.0 (OpenJDK 64-Bit Server VM, Java 11.0.4).
Type in expressions for evaluation. Or try :help.
```

Type `:help` to get the help info of all available commands.

## Hello Scala 

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

## Values and Variables

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

## Numeric Types

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

## Chars and Strings

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

