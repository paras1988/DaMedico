package com.interviewbit.dynamicProgramming.Suffix_prefix_dp;

//WAYSS
public class CoinSumInfinite {

    public static void main(String[] args) {
        int[] arr= {2,3,4};
        System.out.println(new CoinSumInfinite().coinchange2Recur(arr,4));
        System.out.println(new CoinSumInfinite().memoizedCoinchangeBottomUp(arr,4));
        System.out.println(new CoinSumInfinite().memoizedCoinchangeBottomUp_moreSpaceOptimize(arr,4));
    }

    //tabular.   coins/sum matrix
    private int memoizedCoinchangeBottomUp(int[] arr, int sum) {
        int coins = arr.length;
        long[][] res = new long[coins+1][sum+1];
        for(int i=0;i<sum+1;i++){
            res[0][i] = 0;
        }
        for(int i=0;i<coins+1;i++){
            res[i][0] = 1;
        }
        for(int i=1;i<coins+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j-arr[i-1]>=0) {
                    res[i][j] = res[i-1][j] + res[i][j - arr[i-1]];
                }
                else{
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return (int)(res[coins][sum]% 1000007);
    }

    //tabular.   coins/sum matrix
    private int memoizedCoinchangeBottomUp_moreSpaceOptimize(int[] arr, int sum) {
        int coins = arr.length;
        long[] res = new long[sum+1];
        res[0] = 1;
        for(int i=1;i<coins+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j-arr[i-1]>=0) {
                    res[j] = res[j] + res[j - arr[i-1]];
                }
            }
        }
        return (int)(res[sum]% 1000007);
    }

    public int coinchange2Recur(int[] A, int B) {
        return coinchange2RecurUtil(A,A.length,B);
    }

    private int coinchange2RecurUtil(int[] a, int i, int sum) {
        if(sum==0){  return 1; }
        if(sum<0){ return 0; }
        if(i<=0){ return  0; }

        return coinchange2RecurUtil(a,i-1,sum) +
                coinchange2RecurUtil(a,i,sum-a[i-1]);
    }

}
/**
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.
 *
 * Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
 *
 * Example :
 *
 * Input :
 * 	S = [1, 2, 3]
 * 	N = 4
 *
 * Return : 4
 *
 * Explanation : The 4 possible ways are
 * {1, 1, 1, 1}
 * {1, 1, 2}
 * {2, 2}
 * {1, 3}
 * Note that the answer can overflow. So, give us the answer % 1000007
 *
 * */