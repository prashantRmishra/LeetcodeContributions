class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a,b) -> {
            if(Math.abs((a-x)) > Math.abs((b-x))) return 1;
                  else if (Math.abs((a-x)) < Math.abs((b-x))) return -1;
                  else return a-b;
        });
        int i = 0;
        while(i<arr.length){
            queue.add(arr[i]);
            i++;
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty() && k>0){
            list.add(queue.remove());
            k--;
        }
        System.out.println(list);
        Collections.sort(list);
        return list;
    }
}