class Solution {
    public int[][] merge(int[][] intervals) {
    
        if(intervals.length ==0 || intervals ==null) return new int[0][];
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]); // this is great snippet for sorting 
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i[] : intervals){
            if(end >= i[0]){
                end = Integer.max(end,i[1]);
            }
            else{
                list.add(new int[]{start,end});
                start  = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
    } 
}