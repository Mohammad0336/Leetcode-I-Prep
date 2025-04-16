class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false; // edge case 
        
        HashMap<Character, Integer> map = new HashMap(); // map to store char counts
        for (char s : s1.toCharArray()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>(); // map to store window chars
        int windowSize = s1.length();
        for (int i = 0; i < windowSize; i++) {
            window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(window.equals(map)) return true; // if the window == map we know it is true

        for(int i = windowSize; i < s2.length(); i++){ // loop to shift characters in window
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - windowSize);

            window.put(newChar, window.getOrDefault(newChar, 0) + 1);
            window.put(oldChar, window.get(oldChar) - 1);

            if(window.get(oldChar) == 0){ // remove 0 values from map
                window.remove(oldChar);
            }
            if(window.equals(map)) return true; // truth check repeated
        }
        return false;
    }
}

// solved by using two maps one static one dynamic
// dynamic loads and offloads characters to see if it now equals the static
// if loop ends and the check fails return false