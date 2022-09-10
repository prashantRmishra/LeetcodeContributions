class Solution {
    public int reversePairs(int[] nums) {
        return merge(0,nums.length-1,nums);
    }
    public  int merge(int start, int end, int[] arr){
        int count = 0;

        if(end > start){
            int mid = start + (end-start)/2;
            count+=merge(start,mid,arr);
            count+=merge(mid+1,end,arr);
            count+=sort(start,mid,end,arr);
        }
        return count;
    }
    public  int sort(int s,int m,int e, int[] arr){
        int[] p = new int[m-s+1];
        int[] q = new int[e-m];
        int count =0;
        int t = m+1;
        for(int u =s;u<=m;u++){
            while(t<=e && arr[u] > (long) 2*arr[t]){
                t++;
            }
            count+=t-(m +1);
        }
        
        for(int i =0;i<p.length;i++) p[i] = arr[i+s];
        for(int i =0;i<q.length;i++) q[i] = arr[i+m+1];
        int i=0,j=0,k=s;
        while(i<p.length && j < q.length){
            if(p[i]<=q[j]){
                arr[k] = p[i];
                k++;i++;
            }
            else{
                arr[k] = q[j];
                k++;j++;
            }
        }
        while(i<p.length){
            arr[k] = p[i];
            i++;k++;
        }
        while(j<q.length){
            arr[k]=q[j];
            j++;k++;
        }
        return count;
    }
}