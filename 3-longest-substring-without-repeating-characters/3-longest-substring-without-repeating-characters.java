class Solution {
    
    // brute force approach with o(n^2) time compexity 
   /**
    public int lengthOfLongestSubstring(String s) {
        if(s.length() ==0) return 0;
        List<Character> list   = new ArrayList<>();
        int size = Integer.MIN_VALUE;
        for(int j =0;j< s.length();j++){  
            for(int i =j;i< s.length();i++){
                if(!list.contains(s.charAt(i))){
                    list.add(s.charAt(i));
                }
                else {
                     size = size > list.size() ? size : list.size();
                     list.clear();
                    break;
                }
            }
         }
        size = size > list.size() ? size : list.size();
        return size;
    }
    
   */
    //two pointer solution 
       public int lengthOfLongestSubstring(String s) {
           if(s.length() ==0) return 0;
           List<Character> list   = new ArrayList<>();
           int size = Integer.MIN_VALUE;
           int i = 0;int j =i;
           while(i<s.length() && j< s.length() && i<=j){
               if(!list.contains(s.charAt(j))){
                   list.add(s.charAt(j));
                   j++;
               }
               else {
                   size = size > list.size() ? size : list.size();
                   list.clear();
                   i++;
                   j = i;
               }
           }
           size = size > list.size() ? size : list.size();
           return size;
    }
}