class Solution {
    public int minDeletions(String s) {
        int count =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
            
        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Character,Integer> it : map.entrySet()){
            int value = it.getValue();
            while(!set.add(value)){
                value--;
                if(value ==-1) break;
                count++;
               
                
            }
         
        }
        return count;
    }
}
               