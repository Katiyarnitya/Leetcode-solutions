class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
          int buyPrice=prices[0];

          for(int i=1;i<prices.length;i++){
            if(buyPrice>prices[i]){
                buyPrice=prices[i];
            }else{
                maxProfit = Math.max(maxProfit,prices[i]-buyPrice);
            }
          }
          return maxProfit;
    }
}