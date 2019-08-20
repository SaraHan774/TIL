package strings;

public class StringDemo {

    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char [] tempCharArray = new char[len];
        char [] charArray = new char[len];

        //put original String in an array of chars
        for(int i = 0; i < len; i++){
            tempCharArray[i] = palindrome.charAt(i);
        }

        //reverse array of chars
        for (int j = 0; j < len; j++){
            charArray[j] = tempCharArray[len - 1 - j];
        }

        String reversePalindrome =
                new String(charArray);
        //make a new String from char array
        System.out.println(reversePalindrome);

        System.out.println("=== Using String Builder ===");
        stringBuilderDemo(palindrome);
    }

    public static void stringBuilderDemo(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse(); //reverse it
        System.out.println(stringBuilder);

        //stringBuilder.toString() is called implicitly.
        //StringBuffer 은 StringBuilder 와 완전히 같은데, thread-safe 하다는 점만 다르다.
        //method 들이 synchronized 되어 있음.
    }
}
