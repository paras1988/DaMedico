package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HotelBookingPossible {

  public static void main(String[] args) {
    Integer[] A = {35, 8, 23, 22, 35, 6, 48, 45, 33, 43, 37, 12, 42, 3, 31, 38, 5, 33, 15};
    Integer[] B = {43, 32, 34, 46, 74, 50, 95, 62, 59, 79, 83, 19, 88, 34, 75, 42, 42, 50, 58};
    int k = 12;

    ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(A));
    ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(B));
    System.out.print(new HotelBookingPossible().hotel(arrive, depart, k));
  }

  private boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    ArrayList<Pair> combine = new ArrayList<>(arrive.size() * 2);

    for (int i = 0; i < arrive.size(); i++) {
      Pair p1 = new Pair(arrive.get(i), 0);
      Pair p2 = new Pair(depart.get(i), 1);
      if (arrive.get(i).compareTo(depart.get(i)) != 0) {
        combine.add(p1);
        combine.add(p2);
      }
    }

    combine.sort(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return p1.a.compareTo(p2.a);
      }
    });

    int count = 0;
    for (int i = 0; i < combine.size(); i++) {
      if (combine.get(i).b == 0) {
        count++;
      } else {
        count--;
      }
      if (count > K) {
        return false;
      }
    }
    return true;
  }

  private class Pair {
    Integer a;
    Integer b;

    Pair(Integer a, Integer b) {
      this.a = a;
      this.b = b;
    }
  }
}
