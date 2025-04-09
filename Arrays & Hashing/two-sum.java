class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

// Simple problem using a hashmap to track:
// Element: Key
// Index of Element: Value
// Loops through nums
// Calculates rem from the target and current element 
// Checks if the rem is a key in the map
// returns the index values of the keys if the values are met ex [0, 1]
// returns empty array if not