class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(null) || s.equals("")) return 0;
        
		HashSet<Character> set = new HashSet<>();
		int len = 0;
		int max =0;
		int i =0,j=0;
     
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                len++; 
                max  = Integer.max(len,max);
            }
            else{
                len =0;
                set.clear();
                j = i+1;
                i++;
            }
        }
        return max;
    }
}