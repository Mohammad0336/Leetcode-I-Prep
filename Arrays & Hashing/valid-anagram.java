class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c); 
            }
        }

        return map.isEmpty();
    }
}

// An anagram defined is two strings containing the same characters
// in a different order
// To solve this problem a HashMap is used to keep track of:
// Character: Key
// Count of Character: Value
// The second string is searched to see if character counts match
// if map is empty at the end it is an anagram