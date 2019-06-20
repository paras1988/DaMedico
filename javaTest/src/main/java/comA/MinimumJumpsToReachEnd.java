package comA;

/*
 *
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
  Output: 3 (1-> 3 -> 8 ->9)

  First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

 * */
public class MinimumJumpsToReachEnd {

    public static void main(String[] args) {
        int arr[] = {1, 3, 0, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(fun(arr,0));

        int dp[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        System.out.println(memfun(arr, dp, 0));
    }

    private static int memfun(int[] arr,  int[] dp, int i) {

        if(i>arr.length){
            return 0;
        }
        if(i == arr.length){
            return 1;
        }
        if(arr[i] == 0){
            return arr.length;
        }
        int min = arr.length;

        for(int j = i+1; j<= i+arr[i]; j++){

            int jumps;

            if(j<dp.length && dp[j] != -1){
                jumps = 1+dp[j];
            }else{
                jumps = 1+memfun(arr,dp,j);
            }

            if(min > jumps){
                min = jumps;
            }
        }
        dp[i] = min;
        return min;
    }

    private static int fun(int[] arr, int i) {

        if(i>arr.length){
            return 0;
        }
        if(i == arr.length){
            return 1;
        }
        if(arr[i] == 0){
            return arr.length;
        }
        int min = arr.length;

        for(int j = i+1; j<= i+arr[i]; j++){

            int jumps = 1+fun(arr,j);
            if(min > jumps){
                min = jumps;
            }
        }
        return min;
    }
}
