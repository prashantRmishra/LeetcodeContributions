class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i =0;i<groupSizes.length;i++){
            if(map.containsKey(groupSizes[i])){
               if( map.get(groupSizes[i]).size() == groupSizes[i]){
                   list.add(map.get(groupSizes[i]));
                   List<Integer> l = new ArrayList<>();
                   l.add(i);
                   map.put(groupSizes[i],l);
               }
               else{
                   List<Integer> l = map.get(groupSizes[i]);
                   l.add(i);
                   map.put(groupSizes[i],l);
               }
            }
            else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(groupSizes[i],l);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}