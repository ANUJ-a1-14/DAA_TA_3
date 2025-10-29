/* Real life use case:
Real-Life Use Case of LIS

LIS is used to find the longest *upward trend* in data.

Example: Stock Prices
Given daily stock prices, LIS shows the longest period where the price kept increasing:
Prices: 5, 7, 4, 8, 9
LIS: 5 → 7 → 8 → 9
Length = 4
This helps investors identify sustained growth periods for better investment decisions.
*/



class Problem1{
    public static int lis(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int len = 1;
        for(int i=0; i<n; i++){
            dp[i]=1;
        }
        for(int i = 0; i<n; i++){
            for (int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            len = Math.max(dp[i], len);

        }
        return len;
    }
    public static void main(String[] args){
        int[] nums = {2,3,1};
         System.out.println("Length: " + lis(nums)); 
    }
}