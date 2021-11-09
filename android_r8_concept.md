minifyEnabled true --> R8 shrinking 을 킨다. 

walks through code, reachable 한 것들을 고른다 



Tree shaking 

-> identifier renaming 

-> optimization 



aapt2 will generate keep rules to have entry points survived 



field name is used, both written and read, but renamed by R8 



```
class Person(val name : String) 

fun printJson() {
	val gson = Gson()
	val person = Person("Name")
	println(gson.toJson(person))
}

-keep class com.example.myapplication.Person {
	public java.lang.String name; 
}
```



위의 keep 룰을 이용해서 println 했을 때 우리가 기대하는 결과가 나올 수 있다. 



Class inlining 

removes classes that are used locally 

- Builders 
- Lambdas 



d8, r8 

3 compilers : Kotlin compiler runs ... => java byte code => dalvik executable 로 바뀜

R8 : replaceable for proguard 

