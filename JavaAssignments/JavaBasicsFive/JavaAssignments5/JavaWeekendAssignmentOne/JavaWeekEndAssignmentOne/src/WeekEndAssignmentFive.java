// Assignment 5: Recursion
// Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values).

// groupSumClump(0, [2, 4, 8], 10) → true
// groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
// groupSumClump(0, [2, 4, 4, 8], 14) → false

// must find the combination of ints that sum up to the true value

public class WeekEndAssignmentFive {

    public static void main(String[] args){
        int [] nums = {2,4,8};
        int [] numsTwo = {1,2,4,8,1};
        int [] numsThree = {2,4,4,8};
        System.out.println(groupSumClump(0, nums, 10));
        System.out.println(groupSumClump(0, numsTwo, 14));
        System.out.println(groupSumClump(0, numsThree, 14));
        
    }
    public static boolean groupSumClump(int start, int[] nums, int target) {
        if(target == 0){
  	        return true;
        }
        if(start == nums.length){
            return false;
        }

        if(groupSumClump(start + 1, nums, target - nums[start])){
            return true;
        }
        return groupSumClump(start + 1, nums, target);
    }

}


