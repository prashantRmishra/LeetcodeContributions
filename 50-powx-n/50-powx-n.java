
//this is naive approach its not optimal its gonna take O(N) time
// class Solution {
//     public double myPow(double x, int n) {
//         double result = 1.0;
        
//         for(int i =0;i<Math.abs(n);i++){
//             result = result*x;
//         }
//         if(n<0) return 1/result;
//         return result;
//     }
// }
//we will use something called binary exponential approach
//this uses the concept of odd and even exponential 
//if x^n if n is even it can be written as (x^2)^(n/2) 
//if x^n is odd then it can be written as x* (x^(n-1)) here (x^(n-1)) is again even so same approach
//solution:
class Solution{
    public double myPow(double x, int n){
        double result =1.0; 
        long nn =n;
        if(n<0) nn = -1*nn;
        while(nn > 0){
            if(nn%2==0){
                x =  x*x;
                nn = nn/2;
            }
            else{
                result = result*x;
                nn = nn-1;
            }
        }
        if(n<0) result = (double)( 1.0)/(double)(result);
        return result;
        
    // double ans = 1.0;
    // long nn = n;
    // if (nn < 0) nn = -1 * nn;
    // while (nn > 0) {
    //   if (nn % 2 == 1) {
    //     ans = ans * x;
    //     nn = nn - 1;
    //   } else {
    //     x = x * x;
    //     nn = nn / 2;
    //   }
    // }
    // if (n < 0) ans = (double)(1.0) / (double)(ans);
    // return ans;
    }
}
