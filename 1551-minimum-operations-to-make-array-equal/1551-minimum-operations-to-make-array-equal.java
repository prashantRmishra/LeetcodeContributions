class Solution {
    public int minOperations(int n) {
        // lets build the array first
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = 2*i +1;
        }
        int target = Arrays.stream(arr).reduce(0,(a,b)->a+b)/n;
        int noOfOperations = 0;
        for(int i =0;i<n;i++){
            noOfOperations+=Math.abs(target-arr[i]);
        }
        return noOfOperations/2;
    }
}