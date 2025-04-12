class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        
                int s1 = Integer.parseInt(stack.pop());
                int s2 = Integer.parseInt(stack.pop());
                
                int result = switch (s) {
                    case "+" -> s2 + s1;
                    case "-" -> s2 - s1;
                    case "*" -> s2 * s1;
                    case "/" -> s2 / s1;
                    default -> 0;
                }; 

                stack.push(String.valueOf(result));
            } 
            else {         
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

// utilizing reverse polish notation to calculate output
// you are giving an array of strings with integers and operations
// the stack stores integer values 
// when a operation is seen as a character 
// stack pops two most recent integers stored converts them to int from str
// a switch is used to get the result of operation and push the value to stack as str
// if it is not an operation the integer is added to the stack
// when all operations are completed only one value should be left in the stack
// from there it is returned