class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int integerValue = 0;
        int i = s.length()-1;
        while(i>0){
            if(s.charAt(i)=='V' && s.charAt(i-1)=='I'){
                integerValue+=4;
                i=i-2;
            }
            else if(s.charAt(i)=='X' && s.charAt(i-1)=='I'){
                integerValue+=9;
                i = i-2;
            }
            else if(s.charAt(i)=='L' && s.charAt(i-1)=='X'){
                integerValue+=40;
                i = i-2;
            }
            else if(s.charAt(i)=='C' && s.charAt(i-1)=='X'){
                integerValue+=90;
                i = i-2;
            }
            else if(s.charAt(i)=='D' && s.charAt(i-1)=='C'){
                integerValue+=400;
                i = i-2;
            }
            else if(s.charAt(i)=='M' && s.charAt(i-1)=='C'){
                integerValue+=900;
                i = i-2;
            }
            else{
                
                integerValue+=map.get(s.charAt(i));
                i--;
            }
            
        }
        if(i==0) integerValue+=map.get(s.charAt(i));
        return integerValue;
    }
}