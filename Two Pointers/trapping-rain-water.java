class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int trapped = 0, left_max = 0, right_max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    trapped += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    trapped += right_max - height[right];
                }
                right--;
            }
        }
        return trapped; 
    }
}

// set variables for trapped water left and right pointers and max pointer height trackers
// set loop condition to ensure enclosed is calculated
// in the loop you have two checks height[left] < height[right] or height[left] >= height[right]
// trapped = current trapped plus side_max - current side_height
// on each side you compare the max of the side to ensure trapped water is calculated
// increment pointers and return trapped at the end of the loop