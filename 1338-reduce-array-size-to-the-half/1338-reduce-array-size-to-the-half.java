class Solution {
    public int minSetSize(int[] arr) {
        int setSize = 0; // initialize you set size
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> q  = new ArrayList<>();
        
        for(int i =0;i< arr.length;i++){
            q.add(arr[i]);// add values to the list 
            // also add values to the map to get the count(frequency) of each element present in the array arr;
            if(map.containsKey(arr[i])){
                int val = map.get(arr[i]);
                map.put(arr[i],++val);
            }
            else map.put(arr[i],1);
        }
        //sort the map in descending order of the frequency of the elements
        /*
        example [5,5,5,3,3,3,3,2,2,7] => [5=3,3=4,2=2,7=1] => decresing order of frequncy
        =>[3=4,5=3,2=2,7=1]*/
        List<Map.Entry<Integer,Integer>> list = map.
            entrySet().
            stream().
            sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
            collect(Collectors.toList());
        int length = arr.length;
        for(Map.Entry<Integer,Integer> l: list){
            int freq = l.getValue(); // example (3=4) key = 3 and value =4 ( ie frequncy of 3 is 4)
            length-=freq; // decrease the length value by frequncytimes of the element
            setSize++;
            if(length <=arr.length/2) break; // as soon as the length becomes less than or equals to arr.lenght wolla you have got your set length;
        }
        return setSize;
    }
}