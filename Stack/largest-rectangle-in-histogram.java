class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}

// A stack is used to store indexes of heights
// maxArea is initialized at 0 and n equals array length
// a loop is used to run through the array
// within the a while loop after the first index is used to compare curr to stack stored height
// in the case where curr is less a calculation for maxArea is done and compared to prev
// if the loop condition is not met value is added to the stack
// at the end maxArea is returned