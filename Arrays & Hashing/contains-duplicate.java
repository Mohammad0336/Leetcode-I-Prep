class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            if(!unique.add(n)) return true;
        }
        return false;
    }
}

// Utilizing a HashSet to track seen elements in nums array
// Loop looks at all elements in array 
// Adds elements to unique if it cannot perform 
// that function there is a duplicate and returns true
// false is default meaning no duplicate values exist