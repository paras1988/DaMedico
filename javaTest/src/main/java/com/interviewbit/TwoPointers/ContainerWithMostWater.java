package com.interviewbit.TwoPointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3};
        System.out.println(new ContainerWithMostWater().maxArea(arr));

    }

    public int maxArea(int[] A) {
        int i =0;
        int j =A.length-1;

        int max = (j-i)*(Math.min(A[i],A[j]));
        while (i<j){
            if(A[i]<A[j]){
                i++;
            }
            else{
                j--;
            }

            int temp = (j-i)*(Math.min(A[i],A[j]));

            if(temp > max){
                max = temp;
            }
        }
        return max;
    }
}
/*Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

 Note: You may not slant the container.
Example :

Input : [1, 5, 4, 3]
Output : 6

Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
So total area = 3 * 2 = 6
*/