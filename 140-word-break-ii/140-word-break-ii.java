class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
       // Write your code here.
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set  = new HashSet<>();
        for(String str  : wordDict) set.add(str);
        getWords(0,s,"",list,set);
        //System.out.println(list);
        return list;
	}
    public void getWords(int index,String s , String temp, ArrayList<String> list,HashSet<String> set){
        if(index>=s.length()){
            list.add(temp.trim());
            return;
        }
        for(int i = index;i<s.length();i++){
            if(!set.contains(s.substring(index,i+1))) continue;
            int len = temp.length();
            temp+=s.substring(index,i+1)+" ";
            getWords(i+1,s,temp,list,set);
            temp = temp.substring(0,len);
        }
    }
}