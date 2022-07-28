class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray); 
        for(int i = 0 ;i<sArray.length;i++){
            if(sArray[i]!=tArray[i]) return false;
        }
        return true;
        // for( int i = 0;i< s.length();i++){
        //     int index  = t.indexOf(s.charAt(i));
        //     if(index==-1) return false;
        //     t = t.replaceFirst(String.valueOf(t.charAt(index)),"");
        // }
        // return true;
        
       /*
        HashMap<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap   = new HashMap<>();
        for(char c : s.toCharArray()){
            sMap.put(c,sMap.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        if(sMap.size()!=tMap.size()) return false;
        System.out.println(sMap + " "+ tMap);
        for(Map.Entry<Character,Integer> entry : sMap.entrySet()){
            if(!tMap.containsKey(entry.getKey()) || tMap.get(entry.getKey())!=entry.getValue()) return false;
        }
        return true;
       */
    }
}