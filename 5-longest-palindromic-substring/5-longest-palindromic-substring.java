class Solution {
    public String longestPalindrome(String s) {
        //the lcs approach won't work here
        //we will have to use traditional approach of two loops for finding longest
        //palindromic subsequence
        int start=0;
        int length = 1;
        int n = s.length();
        if(n<2) return s;
        for(int i =0;i<n;i++){
            int low = i-1;
            int high = i+1;
            //below will check till how long the index values of high are equal to current index
            //which will be palindrome obviously
            while(high < n && s.charAt(high) == s.charAt(i)){
                high++;
            }
            //same logic as above for low index
            while(low>=0 && s.charAt(low) == s.charAt(i)){
                low--;
            }
            //finally low and high together
            while(low >=0 && high<n && s.charAt(low)== s.charAt(high)){
                low--;
                high++;
            }
            int len  = high-low -1;
            if(len> length){
                length = len;
                start = low+1;
            }
            
        }
        return s.substring(start,start+length);
    }
}