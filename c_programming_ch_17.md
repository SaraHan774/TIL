### Dynamically allocated strings 

```
char *concat(const char *s1, const char *s2){
	char *result; 

	 result = malloc(strlen(s1) + strlen(s2) + 1); 
	 if(result == NULL){
		printf("Error : malloc failed in concat \n"); 
		exit(EXIT_FAILURE); 
	}
	strcpy(result, s1); 
	strcat(result, s2); 
	return result; 
}
```
- 사용하지 않는 변수는 `free()` 
- always use `sizeof() for malloc`

### Deallocating storage 

- `malloc` and other memory allocation functions obtain memory blocks from a storage pool known as the ***heap***. 
- Calling these functions too often -- or asking them for large blocks of memory -- can exhaust the heap, causing the functions to return a **null pointer**. 
- A block of memory that is no longer accessible to a program is said to be **garbage**. 
- A program that leaves garbage behind has a **memory leak**. 
- Some languages provide **garbage collector** that automatically locates and recycles garbage, but C does not. 
- `free(Pointer)`

### Linked Lists 
- easier to insert and delete nodes in a linked list. 
- but we lose ***random access*** capability of an array. 
- Any element of an array can be accessed in the same amount of time. Linked list 의 경우 노드가 앞쪽이면 접근 빠르고 뒷쪽이면 느리다. 

### Declaring node type 

```
struct node{
	int value; 
	struct node *next;  // pointer to the next node 
};  // typedef {... } Node 하면 struct 안에서 Node 참조가 안되어서 ? 
```

- when a structure has a member that points to the same kind of structure, as `node` does, we are required to use a structure tag. 
- without the `node` tag, we would have no way to declare the type of `next`. 

- `node` 를 선언했으니, 어디서 list 가 시작하는지 트래킹을 해야 한다. 
- we will need a variable that always points to the first node in the list. `first`. 

### Creating a Node 

1. Allocate memory for the node 
2. Store data in the node 
3. Insert the node into the list 

```
struct node *new_node; 
//allocate memory 
new_node = malloc(sizeof(struct node)); 

//store value
(*new_node).value = 10; //new_node = 10; 과 같다. 
```

### The -> Operator 

- known as ***right arrow selection*** 
- `->` is a combination of the `*` and `.`operations. 
- `scanf("%d", &new_node -> value);`

### add to list 

```
struct node *add_to_list(struct node *list, int n){ //list 의 첫번째 주소값이 first 
	struct node *new_node; 
	new_node = malloc(sizeof(struct node)); 
	if(new_node == NULL){
		printf("Error : malloc failed in add_to_list \n "); 
		exit(EXIT_FAILURE); 
	}
	new_node -> value = n; 
	new_node -> next = list; //first node 
	return new_node; 
}
```

- `first = add_to_list(first, 10)`
- 사용자 입력 받아서 리스트 형성 

```
struct node *read_numbers(void){
	struct node *first = NULL; 
	int n; 
	
	printf("Enter a series of integers (0 to terminate) \n"); 
	for(;;){
		scanf("%d", &n); 
		if(n == 0){
			return first; 
		}
		first = add_to_list(first, n); 
	}
}
```

### searching a list 

```
struct node *search_list(struct node *list, int n){
	struct node *p; 
	for(p = list; p != NULL; p = p->next){
		if(p->value == n) return p; 
	}
	return NULL; 
}
```

- we can eliminate `p` variable 
```
struct node *search_list(struct node *list, int n){
	for(;list != NULL; list=list->next){
	if(list -> value == n) return list; 
}
return NULL; 
}
```

### Deleting a node from a linked list 

1. Locate the node to be deleted 
2. Alter the previous node so that it "bypasses" the deleted node. 
3. Call `free` to reclaim the space occupied by the deleted node. 

- **Trailing Pointer** technique : As we search the list in step 1, we will keep a pointer to the previous node (`prev`) as well as a pointer to the current node(`cur`). 
- if `list` points to the list to be searched and `n` is the integer to be deleted, the following loop implements step 1: 

```
for(cur = list, prev = NULL; cur != NULL && cur -> value != n; prev = cur, cur = cur -> next); 

//performd all the actions needed to search for n. 
//when the loop terminates, cur points to the node to be deleted, while prev points 
//to the previous node. 
```

```
struct node *delete_from_list(struct node *list, int n){
	struct node *cur, *prev; 
	for(cur = list, prev = NULL; 
		cur != NULL && cur -> value != n; 
		prev = cur, cur = cur -> next); 
	
		if(cur == NULL)	{ //n was not found 
			return list; 
		}
		if(prev == NULL){ //n is in the first node 
			list = list -> next; // ??? 
		}
		else{
			prev -> next = cur -> next;  //n is in some other node 
		}
		free(cur); 

}
```

### Pointers to pointers 

- `add_to_list(&first, 10);` 로 넣어야 함. 

```
void add_to_list(struct node **list, int n){
	struct node *new_node; 
	new_node = malloc(sizeof(struct node)); 
	if(new_node == NULL){
		printf("Error : malloc failed in add_to_list \n"); 
		exit(EXIT_FAILURE); 
	}
	new_node -> value = n; 
	new_node -> next = *list; 
	*list = new_node; //&first를 new_node 의 주소값으로 바꾼다. 
}
```
- since `list` is assigned the address of `first`, we can use `*list` as an alias for `first`. 
- In particular, assigning `new_node` to `*list` will modify `first`. 

 

