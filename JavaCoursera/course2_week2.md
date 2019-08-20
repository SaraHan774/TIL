## Week 2 : Strings 
Flesch Index score : measure the readability of a piece of text. 
How can we quantify how readable a text is ? 

### Measure of text readability 
Flesch score = 206.835 = 1.015 (#words / #sentences) - 84.6(#syllables / #words)
**Many words per sentences and many syllables per word** will decrease the readability of the text.
Low score (< 30) 

### Strings can do lots of things ! 
1. length 
2. toCharArray
3. indexOf 
4. charAt 
5. split 

### Lecture notes
* character is a primitive (== operator to check equal)
* for(char c : word.toCharArray()) => will check each position of array
* if( c == letter) { //return true }
* toCharArray returns a copy of the character in the String 
* Strings are immutable
* charAt() returns a **"char"** which does not have a .equals method because it is a primitive data type
* indexOf("string") -> returns the first position that matches the substring.
* split(String regex) -> takes RE as a parameter

#### regex 
split(String pattern)
* want to split any number of spaces
* Regular expression : Characters are basic units 

**3 ways to combine**
1. Repetition 
* Any number of spaces? "[space]+" (use + operator)
* 1개 이상의 공백을 제거한다 
* "2314511167" 에서 ["23", "45", "67"] 을 만들고 싶으면 "1+"
2. Concatenation
* putting regex together, one after another 
* d.getTokens("it") => "i" and "t"
* "it+" => "i" and one or more "t"s
* "i(t+)" => explicit grouping ***when in doubt, just use parentheses***
* "it*" => "i" and 0 or more "t"s ***can match plain "i"***
* "it|st" => either "it" or "st"
* "[123]" => character classes - match any character in this class (set)
* "[1-3]" => match any number, numeral between 1 to 3 
* "[a-f]" => little a to little f
* "[^a-z123 ]" => ^ indicates NOT any characters in this set. I don't want 1, 2, 3 or small letters, and space. 
* example : "123.334.5999.579" ---> ["123", "334", "5999", "579"] 만들려면 d.getTokens("[^.]+");
* **d.getTokens("[^.]");** 쓸 경우 This will match all of the digits, but will match them individually (i.e. "1", "2", "3", "3", etc), instead of grouping them together into string.
* **d.getTokens("[0-9]+");** 과 **d.getTokens("123|334|5999|579");** 도 가능함. 


3. Alternation





