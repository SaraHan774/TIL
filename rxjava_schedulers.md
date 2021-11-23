# Schedulers 

- Log.i 를 사용하면 현재 실행되는 스레드를 표시하도록 달라짐 



```java
String[] objs = {"1", "2", "3"}; 

Observable<String> source = Observable.fromArray(objs)
  .doOnNext(data -> Log.v("Original Data = " + data))
  .subscribeOn(Schedulers.newThread())
  .observeOn(Schedulers.newThread())
  .map(Shape::flip);
  
source.subscribe(Log::i);

CommonUtils.sleep(500); 
```

- observeOn 함수를 지정하지 않으면 subscribeOn 함수로 지정한 스레드에서 모든 로직을 실행한다. 

  