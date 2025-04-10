class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}

// same as original two sum but using pointers
// work with pointers instead of hash map 
// array is sorted so start at both ends
// increment and decrement left and right based on sum of numbers compared to target
// return indexs plus one if they match
// return empty if not