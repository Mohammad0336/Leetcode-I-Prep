class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > max) {
                max = prices[i] - buy;
            }
        }
        return max;
    }
}

// sets buy to first price
// max is initialized at 0 
// loop checks if curr price is less than initial if so price is curr
// if not it checks profit if curr profit is > previous it sets it to max
// returns max at the end