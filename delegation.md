### Delegation Pattern 

소프트웨어 공학에서 위임 패턴이란 상속을 활용했을 때와 같은 코드 재사용성을 얻기 위한 방법으로, 객체 구성 (object composition) 을 허용하는 패턴이다. 

위임에서는 객체가 Delegate 이라는 두 번째 객체에 어떠한 요청을 할당한다. Delegate 은 helper 객체임에도 불구하고 original context 를 갖는다. 

language level 에서 위임을 지원하는 경우 원래 객체를 참조하기 위해 delegate 안에서 `self` 를 내재적으로 갖고 있다. (원래 객체를 참조) 

위임 패턴에서는 self 대신에 실제 객체를 Delegate 에 넘겨주는 방식으로 이루어진다. (함수의 매개변수로 넘겨준다)

sending object, receiving object 

receiving object, delegate 

https://en.wikipedia.org/wiki/Delegation_pattern

```
class Rectangle(val width: Int, val height: Int) {
	fun area() = width * height
}

class Window(val bounds: Rectangle) {
	// delegation 
	fun area() = bounds.area()
}
```

- Window 는 내부에 있는 Rectangle 객체에 area() 콜을 위임한다. 



Language support 

```
interface ClosedShape {
	fun area() : Int 
}

class Rectangle(val width: Int, val height: Int) : ClosedShape {
	override fun area() = width * height 
}

class Window(private val bounds : ClosedShape) : ClosedShape by bounds
// using by keyword
```



---



https://kotlinlang.org/docs/delegation.html#overriding-a-member-of-an-interface-implemented-by-delegation



The delegation pattern has proven to be a good alternative to implementation inheritance, and Kotlin supports it natively requiring zero boilerplate code. 



```
interface Base {
	fun print() 
}

class BaseImpl(val x: Int) : Base {
	override fun print() { print(x) }
}

class Derived(b: Base) : Base by b 

fun main() {
	val b = BaseImpl(10)
	Derived(b).print()
}
```

`Base by b` 에 의해서, b 라는 객체가 Derived 객체 내부적으로 저장된다. 컴파일러는 Base 의 모든 함수들을 생성해서 b 에 이것을 forwarding 한다. (위임한다)



### Overriding a member of interface implemented by delegation 

Override work as you expect : the compiler will use your `override` implementations instead of those in the delegate object. 

Derived 클래스 안에 `override fun printMessage() { print("abc") }` 를 넣고 싶으면, 프로그램은 10 대신에 abc 를 프린트 할 것이다. 



```
interface Base {
	fun printMessage()
	fun printMessageLine()
}

class BaseImpl(val x : Int) : Base {
	override fun printMessage() { print(x) }
	override fun printMessageLine() { println(x) }
}

class Derived(b: Base) : Base by b {
	override fun printMessage() { print("abc") }
}

fun main() {
	val b = BaseImpl(10)
	Derived(b).printMessage()
	Derived(b).printMessageLine()
}

// output : abc10 
```



### Delegates 

#### Observable properties 

``` 
import kotlin.properties.Delegates 

class User {
	var name : String by Delegates.observable("<no name>") {
		prop, old, new -> 
		println("$old -> $new")
	}
}

fun main(){
	val user = User()
	user.name = "first"
	user.name = "second"
}

//output : 
//<no name> -> first
//first -> second
```



 If you want to intercept assignments and *veto* them, use [`vetoable()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/vetoable.html) instead of `observable()`. The handler passed to `vetoable` will be called *before* the assignment of a new property value.



### Storing properties in a map 

```
class User(val map: Map<String, Any?>) {
	val user: String by map 
	val age: Int by map 
}

val user = User(mapOf("name" to "John Doe", "age" to 25))

println(user.name) // prints "John Doe" 
println(user.age) // prints 25 

// user.name 을 하면, getName 자체가 map 에 호출되는 거랑 같은 효과 
```

