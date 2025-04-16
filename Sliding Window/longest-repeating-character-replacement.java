class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);

            while ((end - start + 1) - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

// using array to keep count of each character
// uses a pointer start and two counting vars
// loop confirms char count finds max char count each time
// when (end - start + 1) - maxCount > window size the start is moved up and character at start is deallocated
// each itteration of the loop maxlength is also calculated which is the return