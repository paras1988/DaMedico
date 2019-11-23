package com.interviewbit.arrays.Bucketing_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookingsPossible {

    public static void main(String[] args) {
        Integer[] A = {1, 2, 3, 4 };
        Integer[] B = {10, 2, 6, 14};
        int k = 2;

        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(A));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(B));
        System.out.print(new HotelBookingsPossible().hotel(arrive, depart, k));

    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Collections.sort(arrive);
        Collections.sort(depart);

        int roomReq = 0;
        for(int i=0,j=0;i<arrive.size() && roomReq<=K;){
            if(arrive.get(i)>depart.get(j)){
                roomReq--;
                j++;
            }
            else{
                roomReq++;
                i++;
            }
        }
        if(roomReq>K){
            return false;
        }
        return true;
    }
}
