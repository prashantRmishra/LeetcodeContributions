class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder br = new StringBuilder();
        br.append(x); 
        String str =  br.toString();
        return isPali(str);
        // String str  = br.reverse().toString();
        // if(str.equals(String.valueOf(x))) return true;
        // return false;
    }
    public boolean isPali(String str){
        int i =0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}