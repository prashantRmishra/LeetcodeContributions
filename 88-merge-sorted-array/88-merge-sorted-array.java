class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      for(int i=0;i<n;i++){
          nums1[i+m]=nums2[i];
      }
        merge(nums1,0,nums1.length-1);
        
        
    }
    void merge(int[] arr, int low, int high){
      if(low <high){
        int m = (low+high)/2;
        merge(arr,low,m);
        merge(arr,m+1,high);
        mergeSort(arr,low,m,high);
      }
    }
    void mergeSort(int[] arr , int l, int m, int h){
        int p[] = new int[m-l+1];
        int q[] = new int[h-m];
        
        for(int i=0;i<p.length;i++){
            p[i]=arr[i+l];
        }
        for(int i=0;i<q.length;i++){
            q[i]= arr[i+m+1];
        }
        int i=0,j=0,k=l;
        while(i<p.length && j<q.length){
            if(p[i] <=q[j]){
                arr[k]=p[i];
                k++;i++;
            }
            else{
                arr[k]=q[j];
                k++;
                j++;
            }
        }
        while(i<p.length){
            arr[k] = p[i];
            i++;k++;
        }
         while(j<q.length){
            arr[k] = q[j];
            j++;k++;
        }
        
    }
}