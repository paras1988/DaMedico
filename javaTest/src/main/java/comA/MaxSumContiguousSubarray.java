package comA;


/*
For example: Given the array [-2,1,-3,4,-1,2,1,-5,4]
, the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] finalR = {0,0,0,0,0,0,0,0,0};
        int[] tempR = {0,0,0,0,0,0,0,0,0};

        if(arr[0]>0){
            finalR[0] = arr[0];
            tempR[0] = arr[0];
        }

        for(int i=1;i<arr.length;i++){
            if(tempR[i-1]+arr[i] > 0){
                tempR[i] = tempR[i-1]+arr[i];
            }
            if(tempR[i]>finalR[i-1]){
                finalR[i]  = tempR[i];
            }
        }
        System.out.println(finalR[arr.length-1]);

    }
}
