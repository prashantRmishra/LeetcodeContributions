class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        //we will get next greater element of all the element in the nums2,
        // by that we will easily be able to get the next greater element of all the 
        //elements in nums1;
        for(int i = 0;i<nums2.length;i++){
            if(stack.isEmpty() || stack.peek() > nums2[i]){
                stack.push(nums2[i]);
            }
            else{
                // below while condtion means that we have found
                // greater value that stack top, now we will have to keep on removing 
                //stack top to make sure that we have got next greater value of stack top
                while(!stack.isEmpty() && nums2[i] > stack.peek()){
                    map.put(stack.pop(),nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        //now we have got the next greater value of all the elements in the nums2
        //we can easily get the next greater value of nums1
        int result[] = new int[nums1.length];
        for(int i =0;i<result.length;i++){
            result[i]= map.getOrDefault(nums1[i],-1);// if next greater does not return then default value will be -1
            
        }
        return result;
    }
}