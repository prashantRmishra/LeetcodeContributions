class Solution {
    public int trap(int[] height) {
        // we will use concept of leftMaxima and rightMaxima i.e first we 
        // will find out what is the left max tower and right max tower at a given index(tower) then water stored at current tower will be (min(leftMaxima,rightMaxima)-valAtCurrentTower)
        // finally we will add water stored at all the tower and we will return that value
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int leftMaxima = Integer.MIN_VALUE;
        int rightMaxima = Integer.MIN_VALUE;
        
        for(int i =0;i<height.length;i++){
            if(leftMaxima< height[i]){
                left[i] = height[i];
                leftMaxima = left[i];
            }
            else{
                left[i] = leftMaxima;
            }
        }
        for(int i = height.length-1;i>=0;i--){
            if(rightMaxima < height[i]){
                right[i] = height[i];
                rightMaxima = right[i];
            }
            else{
                right[i] = rightMaxima;
            }
        }
        int water =0;
        for(int i =0;i<height.length;i++){
            int min = Integer.min(left[i],right[i]);
            water+=min-height[i];
        }
        return water;
        
    }
}