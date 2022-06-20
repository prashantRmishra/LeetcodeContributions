class Solution {
   // this is one approach to generate all the possible permutations but its not giving the right results
    /*
     int count =0;
    public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = i+1;
        }
       
        return getAllPermutations(0,arr,k);
    }
    public String getAllPermutations(int ind, int arr[],int k){
        if(ind == arr.length){
            count++;
             //System.out.println(Arrays.toString(arr).replaceAll("[\\[\\], ]","")  +"count "+count);
            if(count == k) return Arrays.toString(arr).replaceAll("[\\[\\], ]","");
        } 
        for(int i =ind;i< arr.length;i++){
            swap(arr,i,ind);
            String str = getAllPermutations(ind+1,arr,k);
            if(!str.equals("#")){
                return str;
            }
            swap(arr,i,ind);
        }
        return "#";
    }
    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
    */
    
    // second approach ,this might give the right solution
    int count = 0;
    List<Integer> l = null;
    public String getPermutation(int n, int k){
        int arr[] = new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = i+1;
        }
        boolean check[] = new boolean[arr.length];
        String s = "";
        if(getAllPermutations(arr,new ArrayList<>(), check, k))
        for(Integer i : l){
            s+=i;
        }
        return s;
    }
    
    public boolean getAllPermutations(int[] arr, List<Integer> list, boolean[] check, int k){
        if(list.size()==arr.length){
            count++;
            if(count ==k){
                l = new ArrayList<>(list);
                return true;
            }
        }
        for(int i =0;i<arr.length;i++){
            if(!check[i]){
                check[i] = true;
                list.add(arr[i]);
                if(getAllPermutations(arr,list,check,k)) return true;
                list.remove(list.size()-1);
                check[i] = false;
            }
        }
        return false;
    }
}