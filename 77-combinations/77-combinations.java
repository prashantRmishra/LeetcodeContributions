class Solution {
    List<List<Integer>> list  = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // first we will create all numbers between 1 to n 
        int arr[] = new int[n];
        
        for(int i =0;i<n;i++){
            arr[i] = i+1;
        }
        findAllPossibleSubsequencesOfSizeK(0,arr,new ArrayList<>(),k);
        return list;
    }
    public void findAllPossibleSubsequencesOfSizeK(int i,int[] arr, List<Integer> l, int k){
        if(i>=arr.length){
            if(l.size()==k){
                list.add(new ArrayList<>(l));
            }
            return;
        }
        else if (l.size()>k) return;
        // else if (l.size() ==k) {
        //     list.add(new ArrayList<>(l));
        //     return;
        // }
        l.add(arr[i]); // take this index;
        findAllPossibleSubsequencesOfSizeK(i+1,arr,l,k);
        l.remove(l.size()-1); //remove this last added element;
        findAllPossibleSubsequencesOfSizeK(i+1,arr,l,k);
        
    }
}