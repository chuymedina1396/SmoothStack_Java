// Assignment 3: Functional
// Given a list of integers, return a list where each integer is multiplied by 2.

// doubling([1, 2, 3]) → [2, 4, 6]
// doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
// doubling([]) → []
import java.util.List;
import java.util.Arrays;

public class WeekEndAssignmentThree {
    public static void main(String[] args) {
        Integer [] myArr = {1,2,3};
        List<Integer> myList = Arrays.asList(myArr);

        Integer [] myArrTwo = {6, 8, 6, 8, -1};
        List<Integer> myListTwo = Arrays.asList(myArrTwo);

        // Invocations Below
        returnListMultiTwo(myList);
        returnListMultiTwo(myListTwo);
    }
    public static List<Integer> returnListMultiTwo(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        System.out.println(nums);
        return nums;
    }
}
