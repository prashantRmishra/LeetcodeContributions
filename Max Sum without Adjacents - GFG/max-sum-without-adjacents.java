// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        
        // we are starting in reverse Order
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(arr,n-1,dp);
    }
    public int solve(int arr[], int index,int dp[]){
       
        if(index==0) return arr[0];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int takeIt = arr[index] + solve(arr,index-2,dp);// as we have taken i we can't take i-1, we have to take i-2
        int donttakeIt = 0+solve(arr,index-1,dp); // as we didnt take the i the element we can take the i-1 th element.
        return dp[index] = Integer.max(takeIt,donttakeIt);
    }
}