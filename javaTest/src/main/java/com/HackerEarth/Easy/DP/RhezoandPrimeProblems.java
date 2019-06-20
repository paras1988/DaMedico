package com.HackerEarth.Easy.DP;

import java.io.*;
import java.util.*;

class RhezoandPrimeProblems {

    public static void main(String[] args) throws IOException{
        //init_memoized();
        init_recursive();
    }

    private static void init_recursive() throws IOException {
        BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(S.readLine());
        long a[]=new long[n+1];
        a[0]=0;
        StringTokenizer st=new StringTokenizer(S.readLine());
        for(int i=1;i<=n;i++)
            a[i]=Integer.parseInt(st.nextToken());
        ArrayList<Integer> prime=new ArrayList<Integer>();
        boolean b[]=new boolean[n+1];
        Arrays.fill(b,true);
        b[0]=false;
        b[1]=false;
        for(int i=2;i*i<=n;i++) {
            if(b[i]) {
                for(int j=i*i;j<=n;j+=i)
                    b[j]=false;
            }
        }
        for(int i=2;i<=n;i++) {
            if(b[i])
                prime.add(i);
        }
        System.out.println(getMaxOfPrimeProbs(a,prime, 0, n));
    }

    private static long getMaxOfPrimeProbs(long[] arr, ArrayList<Integer> prime, int s, int e) {
        long max = 0;
        for(int i=s;i<e;i++){
            for(int j=0;j<i;j++){
                if(prime.contains(i-j)){
                    max = sumOfNum(arr,i,j);
                }
                else{
                    for(Integer p:prime){
                        if(p>i){
                            break;
                        }
                        else{
                            if(p+1<=i-j){
                                max = Math.max(max, getMaxOfPrimeProbs(arr,prime,i,j));
                            }
                            else{

                            }
                        }
                    }

                }
            }
        }
        return max;
    }

    private static long sumOfNum(long[] arr, int i, int j) {
        long sum = 0;
        for(int a=i;a<j;a++){
            sum = sum+arr[a];
        }
        return sum;
    }

    private static void init_memoized() throws IOException {{
        BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int n=Integer.parseInt(S.readLine());
        long a[]=new long[n+1];
        a[0]=0;
        StringTokenizer st=new StringTokenizer(S.readLine());
        for(int i=1;i<=n;i++)
            a[i]=a[i-1]+Integer.parseInt(st.nextToken());
        ArrayList<Integer> prime=new ArrayList<Integer>();
        boolean b[]=new boolean[n+1];
        Arrays.fill(b,true);
        b[0]=false;
        b[1]=false;
        for(int i=2;i*i<=n;i++) {
            if(b[i]) {
                for(int j=i*i;j<=n;j+=i)
                    b[j]=false;
            }
        }
        for(int i=2;i<=n;i++) {
            if(b[i])
                prime.add(i);
        }
        long d[]=new long[n+1];
        d[n]=0;
        for(int i=n-1;i>=1;i--) {
            int size=n-i+1;
            if(b[size])
                d[i]=a[n]-a[i-1];
            else {
                long max=d[i+1];
                for(int x:prime){
                    if(x>size)
                        break;
                    if(i+x+1<=n)
                        max=Math.max(max,d[i+x+1]+a[i+x-1]-a[i-1]);
                    else
                        max=Math.max(max,a[i+x-1]-a[i-1]);
                }
                d[i]=max;
            }//else
        }//for
        out.println(d[1]);
        out.close();
    }
    }
}