class Solution {
    public int reverse(int x) {
        boolean isNegative = x< 0 ? true:false;
        if(isNegative){
            x = x*-1;
        }
        int prevNumber = 0;
        int reverseNumber =0;
        while(x!=0){
            int individualDigit = x%10;
            reverseNumber = reverseNumber*10+individualDigit;
            if((reverseNumber-individualDigit)/10 != prevNumber) return 0;
            prevNumber = reverseNumber;
            x = x/10;
        }
        if(isNegative) reverseNumber= reverseNumber*-1;
        return reverseNumber;
    }
}