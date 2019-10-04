package practice;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertUTC {
    public static void main(String[] args) {
        long time = 1561554154352L;
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(sdf.format(new Date(time)));

        StringBuilder stringBuilder = new StringBuilder("Good Morning");
        stringBuilder.insert(1, "Friend ");
        System.out.println(stringBuilder.toString());

        Pattern p = Pattern.compile("^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher("123123");
        System.out.println(m.matches());

        System.out.println(vowelOnly("haaaahahaaha"));
    }

    public static String vowelOnly(String input){
        Pattern p = Pattern.compile("[AEIOUaeiou]+");
        Matcher matcher = p.matcher(input);
        StringBuilder stringBuilder = new StringBuilder();
        while(matcher.find()){
            stringBuilder.append(matcher.group());
        }
        return stringBuilder.toString();
    }

    public static String vowelOnlySolution(String input) {
        String vowel = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (vowel.contains(String.valueOf(c).toLowerCase())) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
