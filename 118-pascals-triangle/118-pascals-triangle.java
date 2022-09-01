class Solution {
    public List<List<Integer>> generate(int numRows) {
        // we will use simple approach
        List<List<Integer>> list = new ArrayList<>();
        for(int i =1;i<=numRows;i++){
            List<Integer> l = new ArrayList<>();
            int size = i;
           
            for(int j =0;j<size;j++){
                if(j==0) l.add(1);
                //else if (j==size-1) l.add(1);
                else{
                    List<Integer> temp = list.get(list.size()-1);  
                    System.out.println("else "+ temp);
                    while(j<size-1){
                        l.add(temp.get(j) + temp.get(j-1));
                        j++;
                    }
                    l.add(1);
                }
            }
            list.add(l);
             System.out.println(list + " size "+ size);
        }
        return list;
    }
}