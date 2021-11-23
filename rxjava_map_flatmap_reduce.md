# RxJava - map vs flatMap 

- `@SchedulerSupport(value = "none")` 은 스케줄러를 지원하지 않는다는 의미 
- 제네릭 함수형 인터페이스 



```
RxJava 의 제네릭 함수형 인터페이스 

Predicate<T> 
	- boolean test(T t) : t 값을 받아서 참이나 거짓을 반환한다 

Consumer<T>
	- void accept(T t) : t 값을 받아서 처리한다. 반환값 없음. 
  
Function<T, R>
	- R apply(T t) : t 값을 받아서 결과를 반환한다 
```



### map 함수

```java
Function<String, String> getDiamond = ball -> ball + "<>"; 
// Function 인터페이스 적용 

String[] balls = {"1", "2", "3", "4"}; 
Observable<String> source = Observable.fromArray(balls)
															.map(getDiamond); 
source.subscribe(Log::i) // 결과를 로그로 출력한다 
```



### flatMap 함수 

- map 함수는 원하는 입력 값을 어떤 함수에 넣어서 변환할 수 있는 일대일 함수 
- flatMap 은 똑같이 함수에 넣더라도, 결과가 Observable 로 나온다. (일대다 혹은 일대일 Observable)



```java
Function<String, Observable<String>> getDoubleDiamonds = ball -> Observable.just(ball + "<>", ball + "<>"); 

String[] balls = {"1", "2", "3"}

Observable<String> source = Observable.fromArray(balls)
  .flatMap(getDoubleDiamonds); 
source.subscribe(Log::i); 

// 여러개의 string 을 발행하는 observable 이 나온다 
```



### ObservableSource 

- Observable, AsyncSubject, BehaviorSubject, ConnectableObservable 등이 공통으로 구현한 인터페이스 
- Observable 처럼 데이터를 발행할 수 있는 객체를 포괄해서 지칭함 
- Single 클래스에는 SingleSource 라는 별도 인터페이스가 존재함 



### reduce 함수 

- 발행한 데이터를 모두 사용하여 <u>어떤 최종 결과 데이터를 합성</u>할 때 활용함 
- map/filter/reduce 삼종 세트 중 하나 
- 상황에 따라 발행된 데이터를 **취합**하여 어떤 결과를 만들어 낼 때 reduce 계열 사용 



```java
String[] balls = {"1", "2", "3"}; 

Maybe<String> source = Observable.fromArray(balls)
  .reduce((ball1, ball2) -> ball2 + "(" + ball1 + ")"); 
source.subscribe(System.out::println); 

// 3(2(1)) 을 출력함
```



- `Maybe<String>` 
  - reduce 함수를 호출하면 <u>인자로 넘긴 람다 표현식에 의해 결과 없이 완료될 수 있으므로</u>, Observable 이 아니라 Maybe 객체로 리턴된다. 
  - `public final Maybe<T> reduce(BiFunction<T, T, T> reducer)` 



```java
BiFucntion<String, String, String> mergeBalls = (first, second) -> second + "[" + first + "]"
```



