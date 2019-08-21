## Week 4 
1. Abstraction, Interfaces and LinkedLists 
2. Testing and Correctness 
3. Markov Processes and Probabilities 

#### Abstraction 
* Hiding irrelevant details to focus on the essential features needed to understand and use a thing
* We do not know how a car's break works. (under the hood)
* User side : ***behavior*** specified (press the pedal) / <Abstraction Barrier> / Provider (***Implementation*** specified)

#### **Data Abstraction**
* ex. Abstract data type (interfaces, abstract classes in Java)
    * -> concept of ADT goes beyond programming language
* List 인터페이스를 구현한 Linked List 를 알아본다. 

- ***emoji testing!(just for fun)***
:heart: :question: :+1: :two_women_holding_hands: :zap:

#### Linked List vs Array List 
* ADT specifies behavior, but does not specify implementation
* Linked and ArrayList both implement the same interface 
1. An ***ArrayList*** implements the List interface using an array 
	* How long does it take to add and element at the beginning of the array? 
	> 배열의 사이즈는 고정되어 있기 때문에 배열의 가장 앞에 요소를 추가하기 위해서는 원래의 배열보다 더 큰 배열에 요소들을 복사한 후에 새로운 요소를 앞에 추가해야 한다. O(n) 만큼 소요된다. 

2. ***Doubly Linked List*** (Already implemented in Java)
* head -> data - next - prev - data - next (connected with nodes) <- tail 
* Singly Linked List 는 tail 이 없음 

	1. ListNode class (field next, prev)
	* these fields store reference to other list elements
	2. MyLinkedList class (size..., head, tail)
	3. sentinal(dummy) nodes 
		* between head and tail 

* Efficiency question	
* ArrayList - index 를 통해서 바로 접근(random access)할 수 있다 O(1) 
* LinkedList 가 index 를 가질 수 있기는 함. (associate with indices) 구현하는 사람 마음이다.  
	* 임의의 요소에 접근하는 데 걸리는 시간은 O(n)
	* head 와 tail 을 통해서 접근할 수 밖에 없기 때문이다. 
	* head 혹은 tail에 요소를 삽입하는 것은 O(1)

#### Generics and Exceptions 
``` 
class ListNode<E>{
	ListNode<E> next; 
	ListNode<E> prev; 
	E data; 
}
```
* E type can be passed in (parameterized type). Generic. 
* <T> -> parameter for a particular type. 

* *How to handle bad input*? 
```
				//not required since NPE is unchecked, but OK. 내가 안써도 Java에서 잡아줌
public class RememberLast<T> throws NullPointerException
{

	public T add(T element){
		if(element == null){
		//return -1; MUST return a T type 

		//help!!! I don't know what to do! 
		//method that calls this method has to deal with this exception. 

		throw new NullPointerException(
			"RememberLast Object cannot store null pointers."); 
		}
	}
	...
}
```
* ***Linked List implementation***
``` 
class ListNode<E>{
	ListNode<E> next; //Recursive data type 
	ListNode<E> prev; 
	E data; 

	public ListNode(E theData){ //No type parameter in the constructor header
		this.data = theData; 
		//next, prev -> default 'null'
	}
}

public class MyLinkedList<E>{

	private ListNode<E> head; 
	private ListNode<E> tail; 
	private int size; 

	public MyLinkedList(){
		size = 0;
		head = new ListNode<E>(null); 
		tail = new ListNode<E>(null); 
		head.next = tail; 
		tail.prev = head; //connected 
	}
}
```

#### Code correctness 
1. Written, has not compiled 
2. Compiled, have not run 
3. Tested against basic input 
4. Tested against corner cases 
5. Tested against users 

* ***How can we increase confidence***
	* Be critical of our algorithms/ code 
	* Consider / test corner cases 
	* Attempt to formally reason about correctness 
	* Create automated test cases 

* Test Driven development 
1. write tests 
2. write code 
3. Test code 

* Black box testing - user side 
	* often more representative of the user experience of the code 
	* easier to write by someone who is unfamiliar with the implementation 
* Clear box testing - provider side 
	* more knowledgable of potential corner cases which might cause incorrect behavior 
* So what do we test? 
	* don't be to fine-grained
	* ***Usually - methods.***
	* Unit testing! 

* [JUnit](http://junit.org/)
	* allows us to write and run unit tests 
	* built into eclipse 












 

