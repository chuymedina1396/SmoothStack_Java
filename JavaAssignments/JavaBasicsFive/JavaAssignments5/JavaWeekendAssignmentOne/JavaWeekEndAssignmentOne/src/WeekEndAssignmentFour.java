// Given a list of strings, return a list where each string has all its "x" removed.

// noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
// noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
// noX(["x"]) → [""]

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class WeekEndAssignmentFour {

    public static void main(String[] args){
        String [] arr = {"ax", "bb", "cx"};
        List<String> listOfStrings = Arrays.asList(arr);
        System.out.println(noX(listOfStrings));
        
    }
    public static List<String> noX(List<String> strings) {
        return strings.stream()
                .map(x -> x.replaceAll("x", ""))
                .collect(Collectors.toList());
      }
      
}
