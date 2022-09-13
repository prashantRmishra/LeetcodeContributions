class Solution {
    public List<List<Integer>> threeSum(int[] A) {
        Arrays.sort(A);
	    HashSet<List<Integer>> set = new HashSet<>();
		for(int i =0;i<A.length-2;i++){
			int j=i+1,k = A.length-1;
			while(j<k){
				int sum = A[i] + A[j] + A[k];
				if(sum ==0){
					set.add(Arrays.asList(A[i],A[j],A[k]));
				}
				if (sum > 0){
					k--;
				}
				else j++;
			}
		}
		return new ArrayList<>(set);
    }
}