package com.interviewbit.stackAndQueue.stackMath;

public class RainWaterTrapped {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new RainWaterTrapped().trap(arr));
    }

    public int trap(final int[] A) {

        int[] maxFromLeft = new int[A.length];
        int[] maxFromRight = new int[A.length];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i] > max){
                max = A[i];
            }
            maxFromLeft[i] = max;
        }

        max = Integer.MIN_VALUE;
        for(int i=A.length-1;i>=0;i--){
            if(A[i] > max){
                max = A[i];
            }
            maxFromRight[i] = max;
        }

        int ans = 0;
        for(int i=1;i<A.length-1;i++){
            ans += Math.min(maxFromLeft[i],maxFromRight[i]) - A[i];
        }
        return ans;
    }
}
