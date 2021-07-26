// Given a list of strings, return a list where each string has all its "x" removed.

// noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
// noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
// noX(["x"]) → [""]

import java.util.List;
import java.util.function.Function;
import java.util.Arrays;

public class WeekEndAssignmentFour {

    public static void main(String[] args){
        String [] arr = {"ax", "bb", "cx"};
        List<String> myList = Arrays.asList(arr);
        noX(myList);
        
    }

    public List<String> noX(List<String> myList) {
        final Function<String, String> func = s -> {
            if (s.equals("")){
                return s;
            } 
            if (s.charAt(0) == 'x'){
                return func.apply(s.substring(1));
            } 
            else{
                return s.charAt(0) + func.apply(s.substring(1));
            } 
        };
        myList.replaceAll(s -> func.apply(s));
        System.out.print(myList);

    }
}
