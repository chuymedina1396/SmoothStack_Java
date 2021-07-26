// Assignment 2: Functional
// Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)

// rightDigit([1, 22, 93]) → [1, 2, 3]
// rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
// rightDigit([10, 0]) → [0, 0]

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class WeekEndAssignmentTwo {
    public static void main(String[] args){
        Integer [] myArr = {1,22,93};
        List<Integer> myList = Arrays.asList(myArr);

        Integer [] secondArr = {16,8,886,8,1};
        List<Integer> secondList = Arrays.asList(secondArr);

        Integer [] thirdArr = {1,22,93};
        List<Integer> thirdList = Arrays.asList(thirdArr);

        returnListOfInts(myList);
        returnListOfInts(secondList);
        returnListOfInts(thirdList);
        
    }
    public static void returnListOfInts(List<Integer> arr){
        arr.replaceAll(n -> n % 10);
        System.out.println(arr);
    }

}
