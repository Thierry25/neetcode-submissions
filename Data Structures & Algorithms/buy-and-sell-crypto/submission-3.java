class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;

        int max = 0;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                var profit = prices[r] - prices[l];
                max = Math.max(max, profit);
            } else {
                l = r;
            }
            r++;
        }
        return max;
    }
}
