class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int profitSofar =0;
        int soldNow  = 0;
        int boughtPrice = Integer.MAX_VALUE;
        for(int i =0;i<prices.length;i++){
           if(prices[i]<boughtPrice){
               boughtPrice = prices[i];
           }
            soldNow = prices[i]-boughtPrice;
            if(soldNow > profitSofar){
                profitSofar = soldNow;
            }
        }
        return profitSofar;
    }
}