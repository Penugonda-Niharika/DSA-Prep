import java.util.*;

class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // PSE
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }

            stack.push(i);
        }

        // Empty the stack
        stack.clear();

        // NSE
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }

        // Calculate area
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;

            int area = heights[i] * width;

            ans = Math.max(ans, area);
        }

        return ans;
    }
}