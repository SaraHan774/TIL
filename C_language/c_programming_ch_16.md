### Decalaring structure variables 

```
struct {
	int number; 
	char name [NAME_LEN + 1]; 
	int on_hand; 
} part1, part2 //separate namespace
```

- The members of a structure are stored in memory in the order in which they are declared. 
- ex. 메모리 주소 2000 - 2003 : number , 2004 - 2029 : name .... 
- There are no gaps between the members. 

### Initializing struct vars 

```
struct {
 //생략 
} part1 = {528, "Disk Drive", 10}, part2 = {914, "Printer cable", 5}; 
```

- an initializer can have fewer members thant the structure it is initializing; as with arrays, any "leftover" members are given 0 as their initial value. 
- the bytes in a leftover character array will be zero, making it represent the empty string. 

### Designated Initializers

`{.number = 528, .name = "Disk drive", .on_hand = 10}` 

- The combination of the period and the member name is called a ***designator***. 
- Designators for array elements have a different form. 
- The order does not matter. 
- not all values listed in a designated initializer need be prefixed by a designator. 

`{.number = 528, .name = "Disk drive", .on_hand = 10}`
 
- The value `Disk drive` does not have a designator. so the compiler assumes that it initializes the member that follows `number` in the structure. 

### Operations on Structures 

- Most common operation of a structure is selecting one of its members. 
- Structure members are accessed by name, not by position. (arrays are accessed by position)
- The members of a structure  are `lvalues` => they can appear on the left side of an assignment or as the operand in an increment or decrement expression. 

```
part1.number = 258; 
part1.on_hand++; //increments quanitity 
```

- The period is a C operator. It takes precedence over nearly all other operators. 
- `scanf("%d", &part1.on_hand);` contains & and  . operator -> can tell that . precedes & 
- assignment 가능하다. 
	- `part1 = part2` 하면 part2 의 내용들이 part1 으로 복사되어서 들어감. 
	- note that arrays cannot be copied using `=` operator. 
	- 몇몇 프로그래머들은 단순이 배열을 나중에 복사하기 위해서 dummy struct 를 만들기도 한다. 
	- `struct {int a[10]} a1, a2;`  =>  `a1 = a2`  가능해짐. 

### Structure Types 

- 멤버가 같은 여러개의 struct 를 선언해야 할 경우  
- we need to be able to define a name that represents a type of structure, not a particular structure variable. 

1. Declaring structure tags 
- name used to identify a particular kind of structure. 

```
struct part{
	int number; 
	char name[NAME_LEN +1]; 
	int on_hand; 
}; 

//사용할때는 
struct part part1, part2; //와 같이 사용 가능. 반드시 struct 임을 명시해줘야 한다. 

struct part{
	//생략 
}part1, part2; //와 같이 바로 이어서 선언 가능. 
```

2. Defining a Structure Type 
- `typedef` 를 사용해서 실질적인 타입 이름을 정의할 수 있다. 

```
typedef struct{ 
	// 생략 
} Part; //와 같이 선언할 수 있다. 

//사용할때는 
Part part1, part2; //와 같이 선언 가능 
```

- **마지막에 Part 라고 타입을 정의해주어야 하는 것에 유의. **

### Structures as Arguments and Return values 
- Passing a structure to a function and returning a structure from a function both require making a copy of all members in the structure. 
- These operations impose a fair amount of overhead on a program. 
- To avoid this overhead, it is sometimes advisable to pass a ***pointer*** to a structure instead of passing the structure itself. 
- `FILE`  구조체의 경우 현재 열려있는 파일에 대한 정보를 담고 있는데, 따라서 프로그램 안에서 unique 해야 한다. 
- `FILE` 을 리턴하는 함수는 FILE Pointer 를 이용해야 

### Compound Literals 
- `print_part((struct part) {528, "Disk Drive", 10});` 
- `part1 = (struct part) {528, "Disk Drive", 10};`

### Nested Structures 

```
struct person_name{
	char first[FIRST_NAME_LEN + 1]; 
	char middle_initial; 
	char last[LAST_NAME_LEN + 1]; 
};

struct student{
	struct person_name name; 
	int id, age; 
	char sex; 
}student1, student2; 
```

- we can more easily treat names as units of data. 	`display_name(student1.name);` 

### Arrays of Structures 


### Unions 
- Struct 와 달리 메모리가 연속적으로 잡히는 것이 아니라, 같은 메모리에 member 들이 저장된다. 

```
union{
	int i; 
	double d; 
}u;
```

- union 의 크기는 크기가 가장 큰 멤버의 사이즈로 잡힌다. 
- u.i = 82, u.d = 74.8 을 하면 뒤의 것으로 메모리가 overwrite 된다. 
- unions can be copied using the = operator, passed to functions, and returned by fuctions. 

- 초기화 

```
union{
	int i; 
	double d; 
}u={0};  //or u = {.d = 10.0};
```

### Using unions to save space 

```
struct catalog_item{
	int stock_number;
	double price; 
	int item_type; 
	char title[TITLE_LEN + 1]; 
	char author[AUTHOR_LEN + 1]; 
	int num_pages; 
	char design[DESIGN_LEN + 1]; 
	int colors; 
	int sizes; 
}; 
```

- Books, Mugs, Shirts 에 대한 정보를 담는다고 했을 때, item_type 을 int 로 구분해서 struct 를 사용하는 방법도 있지만, Books 만 볼 경우 design 이나 colors 는 의미 없는 정보가 된다. 공간 낭비. 

```
struct catalog_item{
	int stock_number; 
	double price; 
	int item_type; 
	union{
	struct{
		char title[TITLE_LEN + 1];
		char author[AUTHOR_LEN + 1]; 
		int num_pages; 	
		}book; 
	struct{
		char design[DESIGN_LEN + 1]; 
	}mug; 
	struct{
		char design[DESIGN_LEN + 1]; 
		int colors; 
		int sizes; 
	}shirt; 
	}item; 
}; 
```

### Using Unions to build mixed data structures 
- Creating data structures that contain a mixture of data of different types. 
- 예를들어, int 와 double 을 모두 담을 수 있는 배열 

```
typedef union{
	int i; 
	double d; 
}Number; 

//using this union 
Number number_array[1000]; 
//storing values 
number_array[0].i = 5; 
number_array[1].d = 8.395; 
```

### Adding a "Tag Field to a Union" 
- union 의 문제 : 어떤 멤버가 마지막으로 바뀌었는지, 멤버들이 의미있는 값을 담고 있는건지 확인할 길이 없다. 
- Number union 에 들어있는 값을 출력하는 함수 

```
void print_number(Number n){
if(n contains an integer){
	printf("%d", n.i); 
	}
else{
	printf("%g", n.d); 
	}
}
```

- In order to keep track of this information, we can embed the union within a sturcture that has one other member: a "tag field" or a "discriminant", whose purpose is to remind us what is currently stored in the union. 
- `item_type` 이 이 역할을 했었다. 
- Number 타입의 유니언을 embeded union 으로 바꾸어 보자 

```
#define INT_KIND 0 
#define DOUBLE_KIND 1

typedef struct{
	int kind; //tag field 
	union{
		int i; 
		double d; 
	}u; 
}Number; 
```

- `Number` 는 `kind`, `u` 이렇게 두 개의 멤버가 있다. 
- `kind` 의 값은 `INT_KIND` 혹은 `DOUBLE_KIND` 일 것이다. 
- union 에 값을 업데이트 할 때마다 kind 필드도 같이 정의해준다. 

```
n.kind = INT_KIND; 
u.n.i = 82; 
```

### Enumerations 

- In many programs, we will need variables that have only a small set of meaningful values. 
- A Boolean variable, for example, should have only two possible values: "true" and "false"
- A variable that stores the suit of a playing card should have only four potential values : "clubs", "diamonds" , "hearts" and "spades" 
- int 로 값을 구분하거나, #define 으로 나열하는 것은 좋은 방법이 아니다. 
- C provides a special kind of type designed specifically for variables that haave a smalle number of possible values. An ***enumerated type*** is a type whose values are listed ("enumerated") by the programmer, who must create a name (***ab enumeration constant***) for each of the values. 

```
enum {CLUBS, DIAMONDS, HEARTS, SPADES} s1, s2; 
```

### Enumeration types and type names 
- 1) declaring a tag 
- 2) using `typedef` to create a genuine type name
#### 1) 
- `enum suit {CLUBS, DIAMONDS, HEARTS, SPADES};`
- 선언 : `enum suit s1, s2;`
#### 2) 
- `typedef enum { ... } Suit;`
- 선언 : `Suit s1, s2;`

### Enumerations as Integers 
```
enum suit {CLUBS = 1, DIAMONDS = 2 ... }; 

//default value = 0 

int i; 
enum {CLUBS, DIAMONDS, HEARTS, SPADES} s; 
//compiler treats 's' as a variable of some integer type. 각각 0, 1, 2, 3 이다. 
i = DIAMONDS; 
s = 0; 
s++; // s = 1 
i = s + 2; // i = 3
```

### Using Enumerations to Declare "Tag Fields" 

```
typedef struct{
	enum {INT_KIND, DOUBLE_KIND} kind; 
	union{
		int i; 
		double d; 
	}u; 
}Number; 
```

- macro 를 쓰지 않고 struct 안에다가 상수를 정의한다. 





