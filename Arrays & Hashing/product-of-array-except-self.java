class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        } // 1, 1, 2, 6

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        } // 24, 12, 4, 1

        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }    
        return res;   
    }
}

// builds an array of prefix and suffix and res
// each array sets the curr element to one and calculates nums post or pre
// res array is the prefix[i] and suffix[i] product