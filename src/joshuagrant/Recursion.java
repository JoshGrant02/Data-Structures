package joshuagrant;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(stringClean("yyzzza"));
    }

    private static int length(String s) {
        //Base case
        if (s == null || s.equals("")) {
            return 0;
        }
        //Recursive case
        return 1 + length(s.substring(1));
    }

    private static String stringClean(String str) {
        System.out.println(str);
        if (str.length() < 2) {
            return str;
        }
        char firstChar = str.charAt(0);
        char secondChar = str.charAt(1);
        if (firstChar == secondChar) {
            return firstChar + stringClean(str.substring(2));
        }
        return firstChar + stringClean(str.substring(1));
    }
}
