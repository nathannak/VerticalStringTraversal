import java.io.CharArrayReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //"GEEKS FOR GEEKS" -> "GFG EOE ERE K*K S*S"
        System.out.println(verticalTraversal("GEEKS FOR GEEKS"));

    }

    public static String verticalTraversal (String s) {

        //find max length of any word
        String[] arr = s.split(" ");

        int max = 0;

        for(String str : arr) {

            max = Math.max(max,str.length());

        }

        //now we have how many 'keys' need to go into map : max number of keys

        Map<Integer, char[] > map = new HashMap<>();

        for(int i = 0 ; i < max ; i++) {

            //how many columns we have? one for each word, see: https://www.geeksforgeeks.org/vertical-order-traversal-in-strings/
            //not that values in map have same length as arr above
            char[] temp = new char[arr.length];
            Arrays.fill(temp,'*');
            map.put(i ,temp);

        }

        //now we have a map with keys as longest word length, and columns as number of substrings in s, separated by white space

        //now fill characters
        for(int i = 0 ; i < max ; i++) {

            char[] charArr = map.get(i);

            //charArr and arr have same length: number of strings in arr [main string broken by white space]
            //for each string get and write the i'th char, if not long enough, else it remains as *
            for(int j = 0 ; j < arr.length; j++) {

                //get i'th (key #) char from each string in arr
                if(i < arr[j].length())
                    charArr[j] = arr[j].charAt(i);

            }
        }

        //write values back to a string and return, using stringbuilder
        StringBuilder res = new StringBuilder();

        for(char[] cArr : map.values()) {
            String str = new String(cArr);
            res.append(str);
            res.append(" ");

        }

        res.deleteCharAt(res.length()-1);

        return res.toString();

    }

}
