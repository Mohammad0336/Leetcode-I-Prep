class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int right = height.length - 1, left = 0;

        while(left < right){
            int length = right - left; 
            int box_height = Math.min(height[left], height[right]);
            area = Math.max(area, box_height * length);
            if(height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
            
        }
        return area;
    }
}

// set variable for area and two pointers
// in loop condition left < right to ensure enclosed area is calculated
// calculate the box height using the min of two heights right and left
// multiple it by length which is the difference in indexes and you get area
// compare it to existing area and return area after loop completes 