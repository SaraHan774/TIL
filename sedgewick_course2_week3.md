## Week 3 : Measuring performance
1. Big O 
2. Benchmarking 
### In the real world : efficiency 
* fast program is important whatsoever 
* how you design is important 
* millions of users billions of requests 
* has to test impact on the latency that is seen by users 
### Algorithm performance 
* Algorithm : strategy for solving a problem 
* ***algorithm analysis is independent from hardware.***
* ***algorithm analysis is independent from the specific language in which the algorithm is implemented*** 
### Our Motivation for Asymptotic Analysis 
* How long does it take ? -> just time it ? 
* This time that we get might not tell us how "good" is the algorithm
* what might impact that time ? libraries, optimizations, computers, compilers ... 
#### 1. Count Operations instead of time
* focus on what we can control. 
* large input = more operations 
#### 2. focus on how performance scales (Asymptotic : 점근성의)
* if list is twice as long, how much more time does it take to search it? 
* but, is size all that matters ? 
#### 3. go beyond input size 
* how might happen according to the internal structure of the input 
### 2. Counting Operations 
1. Count operations from code 
2. Describe behavior for a given input

"san diego" 에서 'a'를 찾기 
전체 스트링을 처음부터 순회하는 것은 **Linear Search** 이다. 
```
public static boolean hasLetter(String word, char letter){
for(int i = 0; i < word.length() ; i++){
	if(word.charAt(i) == letter){
	return true; 
	}
    }
    return false; 
}
```
* execution of a statement 
* evaluation of a conditional branch
* boolean check 
-> all increases number of operations. 

* inside a for loop : i가 작은지 확인, charAt을 통해 비교, i를 증가 -> 3번의 연산 
* 만약 'x'를 찾는다고 하면 int i = 0; 을 할당하는 연산 한 번 + 마지막 return false 연산 까지 해서 총 29번의 연산이 된다. 

***what counts as an operation?*** 
* only worry about what we can control 
* Operation : basic unit that does not change as the input changes 
* so, when we have a single line of code that is both assignment and declaration, it is a single operation [?]

## Core : Introduction to Asymptotic Analysis, Part 1 
* why is it useful ? 
* calculate BIG O 
* do not worry about what we cannot control 
	- Initialization time 
	- implementations of specific operations 
***Focus on how performance scales***

***Constant Time***
```
if(word.charAt(i) == letter){
return true; 
}
//word -> input (letter 'n' as size of the input)
//how long does it take to execute this 'if' branch? 
//we are doing one comparison. 만약에 true 라면 return 의 연산 1개 추가 
```

***Linear function of N : Linear time***
```
int count = 0 [연산 1번]; 
for (int i = 0 [연산 1번]; i < word.length() [연산 n번] + [마지막에 1번]; i++ [연산 n번]){
count++ [연산 n번]; 
}

//word.length() 로 인해서 input 에 따라 연산 크기가 달라질 것이다. for loop 한 번 더 돌아야 하기 때문에 
//지역변수 선언 : 연산 1 개 , for loop : n times , 
//총 연산 횟수는 3n + 3 이다 
```

* f(n) = O(g(n)) means f(n) and g(n) grow in same way as their input grows up to constants 
* this big O notation captures the rate of growth of two functions 
* ***There are other ways to measure asymtotics***


## Core: Introduction to Asymptotic Analysis, Part 2
1. Drop constants -> 100000 = O(1) a million is big o of one 
* Initialization costs : # of steps does not change with the input size n 
2. Keep only dominant term 
* fastest growing 
* 3n + 3 = O(3n) 
* we drop constants so, O(3n) = O(n)

***Another Linear algorithm***
```
    public static void reduce (int[] vals) {
        int minIndex =0; // O(1)
        for (int i=0; i < vals.length; i++) { // O(n)
//How does this loop depend on the size of the input?  
            if (vals[i] < vals[minIndex] ) { //conditional check 
                minIndex = i; //might update this var depending on the condition 
            }
        }
        int minVal = vals[minIndex]; // O(1)
        for (int i=0; i < vals.length; i++) { // O(n) 
			//goes through the array one at a time 
            vals[i] = vals[i] - minVal; //constant 
        }
    }

//Overall O(1), O(n), O(1), O(n) -> 2n + 2 -> O(n)
```

## Core: Computing Big O with Nested Operations 
* not consecutive for loops, but one loop inside another. 
* **Count from inside out**

* ***Quadratic algorithm***
```
    public static int maxDifference (int[] vals) {
        int max = 0; //O(1)
        for (int i=0; i < vals.length; i++) {
	//for each new value of i is O(n)
	//n many times O(n) -> O(n^2)
            for (int j=0; j < vals.length; j++) {
		//O(n) inner for loop 
                if (vals[i]-vals[j] > max) { 
		// O(1) don't need to worry now. 
                    max = vals[i]-vals[j];
                }
            }
        }
        return max; //O(1)
    }
//Total : O(n^2)
```
***log 밑이 10이고, 지수가 n일 때 tightest big-O bounds 는 O(log 밑 2 지수 n)인 경우이다.***
* We can convert between different bases of logarithms by multiplying by a constant factor.

## Selection Sort 
* 가장 작은 숫자를 찾아서 앞으로 둔다. 
```
public static void selectionSort(int [] vals){
	int indexMin; 
	for(int i = 0; i < vals.length - 1; i++){
	//outer loop : O(n)
	indexMin = i; 
	for(int j = i + 1; j < vals.length; j++){
		//inner loop : O(n - (i + 1))
	if(vals[j] < vals[indexMin]){
		indexMin = j; 
			}
		}
	}
}
```
## Core: Worst, Best, and Average Cases
* Describe why each of these is used 

* hasLetter(String word, char letter) 메소드를 보았을 때 인풋에 따라 필요한 연산의 횟수가 달라지는 것을 알 수 있다. 
* best case : (hasLetter 메소드의 경우) 찾고자 하는 char 이 가장 앞에 있는 것이 best case 이다. 
* worst case (upper bound) : 최악의 경우는 스트링 안에 찾고자 하는 char 이 없는 경우이다. / 혹은 찾고자 하는 char 이 가장 뒤에 있을 때 
* best case <= worst case 
* *why do we care ?* : it is useful to prepare for this extream situations. 
* average case : consider all possible inputs -> average ... this can get messy (realistic but too hard)

## Core: Analyzing Search Algorithms
* Linear search / Binary Search
* O(1) ~ O(n)  /  assumption: sorted array , O(1) ~ O(log n)

## Core: Analyzing Sorting Algorithms
* Selection Sort : O(n^2) ~ O(n^2)
* Insertion Sort : O(n) ~ O(n^2)

## Core: Merge Sort
* explain the use of recursion in merge sort 

* if list has one element, return 
* Devide list in half 
* sort first half 
* sort second half ---> ***RECURSION***
* Merge sorted lists  
* O(nlogn) ~ O(nlogn)

* cf. Quick sort : O(nlogn) ~ O(n^2)













