package com.HackerEarth.Easy.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * You are given an array  of size . You have also defined an array  as the concatenation of array  for infinite number of times.
 * For example, if , then .
 *
 * Now, you are given  queries. Each query consists of two integers,  and . Your task is to calculate the sum of the subarray of  from index  to .
 *
 * Note: As the value of this output is very large, print the answer as modulus .
 *
 * Input format
 *
 * First line:  denoting the number of test cases
 * For each test case:
 * First line: Contains , the size of the array
 * Second line: Contains  space-separated integers corresponding to
 * Third line: Contains  denoting the number of queries
 * Fourth line: Contains  space-separated integers corresponding to
 * Fifth line: Contains  space-separated integers corresponding to
 * Output format
 *
 * For each test case, print  space-separated integers that denote the answers of the provided  queries. Print the answer to each test case in a new line.
 *
 * Constraints
 *
 *
 * Sample Input
 * 1
 * 3
 * 4 1 5
 * 3
 * 1 3 9
 * 4 7 10
 * Sample Output
 * 14 19 9
 * Explanation
 *
 * Query #1:
 * L=1, R=4, elements are {4,1,5,4}. Sum=4+1+5+4=14.
 *
 * Query #2:
 * L=3, R=7, elements are {5,4,1,5,4}. Sum=5+4+1+5+4=19.
 *
 * Query #3:
 * L=9, R=10, elements are {5,4}. Sum=5+4=9.
 */
public class InfiniteArrays {

    public static void main(String[] args) throws IOException {
       new InfiniteArrays().init();
    }
    private void init() throws IOException {
        MyScanner sc = new MyScanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            int q = sc.nextInt();
            long[] strl = new long[q];
            long[] str2 = new long[q];
            int count = 0;
            for(int j=0;j<q;j++){
                strl[j] = sc.nextLong();
            }
            for(int j=0;j<q;j++){
                str2[j] = sc.nextLong();
            }
            long[] res  = solve(arr,strl,str2);

            for(int j=0;j<q;j++){
                System.out.print(res[j]+" ");
            }
            System.out.println("");
        }
    }
    static long[] solve(int[] A, long[] R, long[] L){
        int queries = R.length;
        long[] res = new long[queries];
        for(int j=0;j<queries;j++){
            res[j] = solvePP(A, L[j], R[j]);
        }
        return res;
    }

    static long solvePP(int[] inputArray,  Long right,Long left) {
        int n = inputArray.length;
        if(right<=n){
            long res1 = 0;
            for(int i1=left.intValue();i1<=right.intValue();i1++){
                res1 += inputArray[i1-1];
            }
            return res1%1000000007;
        }
        int value = new Long(left%n-1).intValue();
        if(value<0){
            value=n-1;
        }
        int i1 =  new Long(right%n-1).intValue();
        if(i1<0){
            i1=n-1;
        }
        long interResult = 0;
        int num = 0;
        for(int i=value;i<n;i++){
            interResult += inputArray[i];
            num = num+1;
        }
        for(int i=0;i<=i1;i++){
            interResult += inputArray[i];
            num = num+1;
        }

        long sum = 0;
        for(int i=0;i<n;i++){
            sum += inputArray[i];
        }
        long dd  = right-left+1-num;
        if(dd>0){
            long d = dd/n;
            interResult += d*sum;
        }
        return interResult%1000000007;
    }

    class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = new StringTokenizer("");
        }

        public long nextLong() throws IOException {
            if (st.hasMoreTokens()) {
                return Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            return nextLong();
        }

        String next() throws IOException {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            return next();
        }

        int nextInt() throws IOException {
            if (st.hasMoreTokens()) {
                return Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            return nextInt();
        }
    }
}
