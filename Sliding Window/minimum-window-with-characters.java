class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return ""; // edge case

        int[] tarCount = new int[128]; // array to store character count
        for (char c : t.toCharArray()) {
            tarCount[c]++;
        }

        int[] winCount = new int[128]; // array to store character counts in window
        int required = 0; // each unique character in the target
        for (int count : tarCount) {
            if (count > 0) required++;
        }

        int formed = 0, left = 0, right = 0; // pointers and unique character tracker
        int minLen = Integer.MAX_VALUE, startIndex = 0; // range variables

        while(right < s.length()){ 
            char c = s.charAt(right); // curr character
            winCount[c]++;

            if(tarCount[c] > 0 && winCount[c] == tarCount[c]){ // check to see if curr character matches in arrays
                formed++; // pseudo key value tracker
            }

            while(left <= right && formed == required){ // if the current window contains all target shift left
                if(right - left + 1 < minLen){  
                    minLen = right - left + 1;
                    startIndex = left; // changing ranges to account for the target found
                }

                char leftChar = s.charAt(left);
                winCount[leftChar]--;
                if(tarCount[leftChar] > 0 && winCount[leftChar] < tarCount[leftChar]){ // recounts formed if curr is required
                    formed--;
                }
                left++; // left shift
            }
            right++; // default right shift
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
