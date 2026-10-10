package leetcode.stacks.questions;

import java.util.Stack;

/**
 * Daily Temperatures
 * =====================
 * https://leetcode.com/problems/daily-temperatures
 * 
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * Example 1:
 * ------------
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 
 * Example 2:
 * ------------
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * 
 * Example 3:
 * ------------
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * Constraints:
 * ------------
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {
    int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        // To store the temperature indexes
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // if the stack top temperature is less than or equal
            // to current temperature then pop it
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // if the stack is not empty then find the difference between indexes
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }

            // add the current temperature index to stack
            stack.push(i);
        }

        return result;
    }
}
