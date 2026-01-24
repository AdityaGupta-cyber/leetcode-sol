class Solution {
    public int maxProfit(int[] prices) {
    // Optimal Solution
// In order to maximize the profit, we need to minimize the cost price and maximize the selling price. So at every step, we keep track of the minimum buy price of stock encountered so far. For every price, we subtract with the minimum so far and if we get more profit than the current result, we update the result.


int minSoFar = prices[0];
int profit = 0;


for(int i = 0; i < prices.length; i++){
    minSoFar = Math.min(prices[i],minSoFar);
    profit = Math.max(profit, prices[i] - minSoFar);
}

return profit;

    /*      
    *** Time Complexity - O(n*n); ***

        int maxProfit = 0;

        for(int i = 0; i< prices.length;i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] - prices[i] < 0) continue;

                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);    
            }
        }
        return maxProfit;
    */
}
}