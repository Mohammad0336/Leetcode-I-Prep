class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        if(nums.length == 0) return 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == (nums[i - 1] + 1)){
                count++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                if(count > max){
                    max = count;
                }
                count = 1;
            }
        }
        if(count > max){
            max = count;
        }
        return max;
    }
}

// sorts array and keeps track of sequence count and max 
// starts at index 1 and tracks if the element prior is 1 less
// count is increment if the if is met 
// count is maintain if elements are prior and current are equal
// count is compared with max if those conditions are not met and count is reset
// final check is done at after the loop
// max is returned