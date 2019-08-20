package strings;

public class ValueOfDemo {

        public static void main(String[] args) {
            //using custom String [] args rather than cmd-line
            String [] arguments = {"30", "40"};
            demo(arguments);
        }

        public static void demo(String [] args){
            if(args.length == 2){
                //convert strings to numbers
                float a = (Float.valueOf(args[0])).floatValue();
                float b = (Float.valueOf(args[1])).floatValue();

                //Each of the Number subclasses that wrap primitive numeric types also
                //provides a parse XXX () method. Since a primitive type is returned instead of
                // an object, the parseFloat() method is more direct.
                float parseA = Float.parseFloat(args[0]);
                float parseB = Float.parseFloat(args[1]);

                System.out.println("a + b = " + (a + b));
                System.out.println("a - b = " + (a - b));
                System.out.println("a * b = " + (a * b));
                System.out.println("a / b = " + (a / b));
                System.out.println("a % b = " + (a % b));

                System.out.println("parsed floats : " + parseA + " , " + parseB);
            }else{
                System.out.println("This program " + "requires two command-line arguments.");
            }
        }
}
