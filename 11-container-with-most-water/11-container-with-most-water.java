

/*
width = distance between two poles = (j-i);
height  = minimum height between the two poles = (Math.min(height[i],heigth[j]);
area = width*height;
initially i= 0 and j=height.length -1;

i=0		        j=7
[3,9,3,4,7,2,12,6]

pass 1 : 3,6 = area = ((j-i)*(Math.min(height[i],heigth[j]))=(7*3) = 21; if height[i]<= height[j] then i++ (otherwise we would have incremented j);
pass 2 : 9,6 = area = 36; j++;)(Increment j as per the rule)
pass 3 : 9,12 = 45 ;i++;
pass 4 : 3,12 = 12 ;i++;
...and so on till i < j in while loop
finally return the area which is maximum
This is exactly what the below code does
*/


class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int leftMaxima = 0;
        int rightMaxima = height.length-1;
        int i=leftMaxima,j = rightMaxima;
        int maxArea = Math.max(Integer.MIN_VALUE,Math.min(height[leftMaxima],height[rightMaxima])*(rightMaxima - leftMaxima));
        while(i<j){
            
            if(height[i] > height[leftMaxima]){
                leftMaxima = i;
            }
            if(height[j] > height[rightMaxima]){
                rightMaxima = j;
            }
            if(height[leftMaxima] <= height[rightMaxima]){
                i++;
            }
            else j--;
            maxArea  = Math.max(maxArea,Math.min(height[leftMaxima],height[rightMaxima])*(rightMaxima - leftMaxima));
        }
        return maxArea;
    }
}