package com.interview.companies.Fivetran;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(6);
        l.add(6);
        List<Integer> r = new ArrayList<>();
        r.add(4);
        r.add(4);
        r.add(10);
        r.add(8);
        System.out.println(widestGap(10,l,r));

    }

    public static int widestGap(int n, List<Integer> start, List<Integer> finish) {
        int[] arr = new int[n];
        int[] arrs = new int[n];
        int[] arre = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = 1;
        }
        for(int i=0;i<start.size();i++){
            for(int j=start.get(i)-1;j<=finish.get(i)-1;j++){
                arr[j] = 0;
            }
        }

        int res = 0;
        int temp = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                temp = temp +1;
            }
            else{
                if(temp>res){
                    res = temp;
                }
                temp = 0;
            }
        }
        return res;

    }
}
