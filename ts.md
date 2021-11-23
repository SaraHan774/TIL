# Typescript 
- Static typing 
- OOP capabilities 
- What is it ?
	- Language 
	- Compiler : Converts TypeScript code into native JavaScript, but also provides the programmer with assistance in writing code with fewer errors. 
- Developer can write code that is easier to understand and refactor and contains fewer bugs. 
- Adds discipline to the development workflow by forcing errors to be fixed while still in development. 
- Made by Microsoft 
- TypeScript has no runtime. It uses a process called transpilation. 
- Transpilation is a method where code from one language is "compiled" or converted into another language. 
- What this means is that all TypeScript code ultimately is converted into JavaScript code before it is finally deployed and run. 
- Can use `private` keyword in TypeScript. 
	- _privacy for class fields will be supported in ECMAScript2020. However, as this is a newer feature, it is not supported across all browsers at the time of writing._ 
- JavaScript types are not explicitly set during declaration. They are only inferred at runtime. 
- In TypeScript, types are normally set during declaration. 
- name of a type is not that important, but the properties it has and their types are important to TypeScript compiler. 


```TypeScript 
// shape.ts 

class Person {
	name: string; 
}

const jill: { name: string } = { name: "jill" }; 

const person: Person = jill; // compiler does not complain !  
console.log(person); 


``` 

- possible to define and declare a type at the same time. 
- `tsc shape` ->  `node shape`
 
