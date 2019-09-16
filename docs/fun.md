# Functions and Methods

A standard function has a name, a list of parameters, a return type, and a body. 

```scala
scala> def doubler(x:Int)={x*2}
doubler: (x: Int)Int

scala> val dv=doubler _
dv: Int => Int = $$Lambda$839/0x000000010065e840@3a17acd4
```

An anonymous function does not have a name.

```scala
scala> (x:Int)=>{x*2}
res0: Int => Int = $$Lambda$824/0x000000010064f040@1f42366

scala> res0(3)
res1: Int = 6

scala> val d = (x:Int)=>{x*2}
d: Int => Int = $$Lambda$825/0x000000010064e040@66a472b9

scala> d(3)
res2: Int = 6
```



### Statements and Expressions

If you know programming in any language, you already know about statements and expressions. A statement is the smallest standalone element that expresses some action to be carried out. Whereas an expression in a programming language is something that produces or returns a value.

```scala
println("Hello Scala")
// Output:- Hello Scala
//The above line of code is a statement.
var x = 2 * Math.sqrt(10) / 5
// Output:- x: Double = 1.2649110640673518
//The above line of code is an expression.    
```

In the Functional Programming model, every functional programming statement should have a capability to return a value. In other words, you can say that we do not have statements in  functional programming. We only have expressions. That is the ground rule for functional statements. This rule is even valid for print statement. The example below proves that a println returns a value.

```scala
scala>val x=println("Hello Scala!")
Hello Scala!
x: Unit = ()
```



### Tail recursion

A tail call or a tail recursion is a function call performed as the last action.

```scala
scala> :paste
// Entering paste mode (ctrl-D to finish)

 def factorial(n: Int): Int = {
     if (n <= 0)
     throw new Exception("boom!")
     else
     return n * factorial(n-1)
 }

factorial(5)

// Exiting paste mode, now interpreting.

java.lang.Exception: boom!
  at .factorial(<console>:3)
  at .factorial(<console>:5)
  at .factorial(<console>:5)
  at .factorial(<console>:5)
  at .factorial(<console>:5)
  at .factorial(<console>:5)
  ... 28 elided


scala> :paste
// Entering paste mode (ctrl-D to finish)

 def  factorial(n: Int, f:Int): Int = {
     if (n <= 0)
     throw new Exception("boom!")
     else
     return factorial(n-1, n*f)
 }

factorial(5,1)

// Exiting paste mode, now interpreting.

java.lang.Exception: boom!
  at .factorial(<pastie>:3)
  ... 37 elided

```

You can see that there is only one function call in the stack trace because the compiler converts the tail recursion to a loop. If you think that a factorial function with two input parameters looks odd,
you can wrap it into an outer function.

```
def factorial(i:Int):Int = {
    def  tFactorial(n: Int, f:Int): Int = {       
        if (n <= 0)  f
        else  tFactorial(n-1, n*f)      
    }    
    return  tFactorial(i,1)
}    
```

## Pure functions

1. The Function input solely determines the Function output. 
2. The Function does not change its input. 
3. The Function does not have any side effects.

If a Function qualifies for above three conditions, it is a pure function.

A function is said to be referentially transparent if we can replace it with its corresponding value without changing the program's behavior.

```scala
var g = 10
def testRT(i:Int):Int = {
    g = i+g; 
    return g
}
val v1 = testRT(5)
//Output:- v1: Int = 15
val v2 = testRT(5)
//Output:- v2: Int = 20   
```

1. The function `testRT` violates the first principle. Its output depends upon an  external variable                                 *g*. 
2. The  `testRT` qualifies for the second rule because it does not modify the  input  parameter.                             
3. It is not eligible to qualify the third law. The `testRT` has a side effect because it changes the state of an external  variable.                             

## Higher order functions

Higher order functions take other functions as parameters or return a function as
a result.

```scala
scala> def doubler(x:Int)=x*2
doubler: (x: Int)Int

scala> def tripler(x:Int)=x*3
tripler: (x: Int)Int

scala> def fx(x:Int, f:Int=>Int)=f(x)
fx: (x: Int, f: Int => Int)Int

scala> fx(3, doubler)
res1: Int = 6

scala> fx(3, tripler)
res2: Int = 9

```

