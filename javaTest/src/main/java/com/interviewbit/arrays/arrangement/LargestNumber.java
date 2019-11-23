package com.interviewbit.arrays.arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
  public static void main(String[] args) {
    Integer[] A = {8,89};
    List<Integer> list = new ArrayList<>();
    for (int i:A){
      list.add(i);
    }

    System.out.print(new LargestNumber().largestNumber(list));
  }
  // DO NOT MODIFY THE LIST
  public String largestNumber(final List<Integer> arr) {
    Collections.sort(arr,new LargestNumber().new MyComparator());
    String res= "";
    for(Integer a:arr){
      res = res.concat(a.toString());
    }
    int i=-1;
    for(Character c:res.toCharArray()){
      if(c=='0'){
        i++;
      }
      else
        break;
    }
    if(i !=-1){
      res = res.substring(i);
    }
    return res;
  }

  public class MyComparator<Integer> implements Comparator<Integer> {

    @Override
    public int compare(Integer s1, Integer s2) {
      String i1= s1.toString().concat(s2.toString());
      String i2= s2.toString().concat(s1.toString());
      return i2.compareTo(i1);
    }

  }
}
