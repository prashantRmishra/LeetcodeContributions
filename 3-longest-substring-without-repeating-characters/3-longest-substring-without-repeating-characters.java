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
                max  = Integer.max(max,set.size());
            }
            else{
                set.clear();
                j = i+1;
                i++;
            }
        }
        return max;
    }
}