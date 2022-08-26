import java.util.StringJoiner;
class Solution {
    public String reverseWords(String s) {
        String[] ch = s.split(" ");
        int i =0,j=ch.length/2;
        while(i<j){
            String temp = ch[i];
            ch[i] = ch[ch.length-i-1];
            ch[ch.length-i-1] = temp;
            i++;
        }
        StringJoiner sJoiner = new StringJoiner(" ");
        for(int k =0;k<ch.length;k++){
            //System.out.println("String is"+ch[k]+"h");
            if(!ch[k].equals(""))
                sJoiner.add(ch[k]);
        }
        return sJoiner.toString().trim();
    }
}