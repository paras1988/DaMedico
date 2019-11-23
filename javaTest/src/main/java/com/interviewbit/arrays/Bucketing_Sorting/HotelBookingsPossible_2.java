package com.interviewbit.arrays.Bucketing_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookingsPossible_2 {

    public static void main(String[] args) {
        Integer[] A = {1, 2, 3, 4 };
        Integer[] B = {10, 2, 6, 14};
        int k = 2;

        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(A));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(B));
        System.out.print(new HotelBookingsPossible_2().hotel(arrive, depart, k));

    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);

        int count = 0;
        int a= 0,d = 0;
        for(;a<arrive.size();){
            if(arrive.get(a)<=depart.get(d)){
                System.out.println(arrive.get(a));
                ++count;
                ++a;
            }
            else{
                System.out.println(arrive.get(d));
                --count;
                ++d;
            }
            if(count>K){
                return false;
            }
        }
        return true;
    }
}
