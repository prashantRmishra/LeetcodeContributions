class Solution {
    public int maximumUnits(int[][] boxType, int truckSize) {
        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int i = 0;i<boxType.length;i++){
            q.add(new Pair(boxType[i][0],boxType[i][1]));
        }
        int sum =0;
        int result =0;
        int val = 0;
        while(!q.isEmpty() && truckSize > 0){
           /*
            Pair<Integer,Integer> p = q.remove();
           
            if(result+1>truckSize){
                //System.out.println(result + " + "+p.getKey()+" is more than "+truckSize);
                 continue;
            }
            result+=1;
            sum+=p.getValue();
            int key = p.getKey()-1;
            if(key > 0){
                q.add(new Pair(key,p.getValue()));
                //System.out.println("sum is "+sum+" adding " + key+ ","+ p.getValue());
            }*/
            Pair<Integer,Integer>  p  = q.remove();
            int minValKey = Integer.min(p.getKey(),truckSize);
            sum+=minValKey*p.getValue();
            truckSize = truckSize-minValKey;
        }
        return sum;
    }
}