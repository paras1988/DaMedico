package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HotelBookingPossible {

  public static void main(String[] args) {
    Integer[] A = {35, 8, 23, 22, 35, 6, 48, 45, 33, 43, 37, 12, 42, 3, 31, 38, 5, 33, 15};
    Integer[] B = {43, 32, 34, 46, 74, 50, 95, 62, 59, 79, 83, 19, 88, 34, 75, 42, 42, 50, 58};
    int k = 11;

    ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(A));
    ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(B));
    System.out.print(new HotelBookingPossible().hotel(arrive, depart, k));
  }

  private boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Collections.sort(arrive);
    Collections.sort(depart);

    int s = arrive.size();
    int e = depart.size();

    int count = 0;
    int i = 0;
    int j = 0;
    while (i < s && j<e){

      if(arrive.get(i)<depart.get(j)){
        i++;
        count++;
      }
      else if(arrive.get(i)<depart.get(j)){
        j++;
        count--;
      }
      else{
        i++;
        j++;
      }
      if(count>K){
        return false;
      }
    }

    while (i< s){
      i++;
      count++;
      if(count>K){
        return false;
      }
    }
    return true;
  }
}
