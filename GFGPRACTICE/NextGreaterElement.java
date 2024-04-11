package GFGPRACTICE;

import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1); // Initialize result array with -1

        Stack<Integer> stack = new Stack<>(); // Stack to track indices of elements

        // Traverse the array in a circular manner (twice the length of nums array)
        for (int i = 0; i < 2 * nums.length; i++) {
            int num = nums[i % nums.length]; // Get the current number from the circular array

            // While the stack is not empty and the current number is greater than the number at the index on top of the stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop(); // Pop the index from the stack
                result[index] = num; // Set the next greater element for the popped index
            }

            // Push the current index onto the stack
            if (i < nums.length) {
                stack.push(i);
            }
        }

        return result;
    }



    public static int[] nextGreater(int [] nums){
        int [] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i< 2 * nums.length; i++){
            int num = nums[i % nums.length];

            while (!st.isEmpty() && nums[st.peek()] < num) {
                int index = st.pop();
                result[index] = num;
            }

            if(i < nums.length){
                st.push(i);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 9, 7, 3, 10};
        int[] nextGreater = nextGreaterElements(nums);

        System.out.println("Next greater elements for each element in the array:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " -> " + nextGreater[i]);
        }
    }
}

