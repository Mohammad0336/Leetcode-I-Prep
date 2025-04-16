class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (characters.contains(s.charAt(i))) {
                characters.remove(s.charAt(left));
                left++;
            }
            characters.add(s.charAt(i));
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

// Utilizing a hashset unique characters are maintained
// we have a pointer and a max variable to track position and longest substring w/ rc
// the loop adds characters to the set and calculates max string 
// if the character is already in the map the left character is removed and left is incremented
// max is returned at the end