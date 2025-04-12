class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) return false; 

                char top = stack.peek();
                if ((ch == ')' && top == '(') || 
                    (ch == ']' && top == '[') || 
                    (ch == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty(); 
    }
}
// utilizing a stack to store open parentheses
// string is checked whether an open parentheses is present to push to stack
// if not the top of the stack is checked to see if the closing parentheses match
// if the stack.peek() matches it is removed if not return false
// the loop is completed if all the checks pass 
// the stack being empty shows that the string had valid parentheses