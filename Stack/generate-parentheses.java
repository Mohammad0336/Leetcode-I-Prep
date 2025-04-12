class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        generate(0, 0, n, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void generate(int open, int close, int n, StringBuilder sb, Set<String> result) {
        // Base case
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            generate(open + 1, close, n, sb, result);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
        if (close < open) {
            sb.append(')');
            generate(open, close + 1, n, sb, result);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }
}

// rather than stacks recursion was used to add all combinations of parentheses cases
// n is the amount of pairs to generate we use counters to keep track of open and close
// brackets, a string builder is used when the sb length equals 2*n you have a pair 
// the pair is added to a hashset to confirm uniqueness
// after the previous calls on the stack allow us to try all combinations and add them to 
// the set