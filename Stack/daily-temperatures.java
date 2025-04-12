class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); 
                result[prevIndex] = i - prevIndex; 
            }
            stack.push(i);
        }
        return result;
    }
}

// n is the array size
// result will be the new array with the values that show index length of greater temp
// stack is used to store current temp's index to compare
// within a loop while statement is used to compare current temp to stack top temp
// if current index is greater length is added to index otherwise the current temp is added to stack
// when an indexes value is greater then peek all things within the stack are compared 
// when loop is completed the result array is returned