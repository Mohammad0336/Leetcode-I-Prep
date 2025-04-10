class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return (sb.toString().equals(s));
        
    }
}

// palindrome if, after converting all uppercase letters into lowercase letters and 
// removing all non-alphanumeric characters, it reads the same forward and backward.
// given this information remove all non alphanumeric characters 
// and set all characters to lower
// rebuild the string from the right to left and see if it matches 
// the original s after transformation