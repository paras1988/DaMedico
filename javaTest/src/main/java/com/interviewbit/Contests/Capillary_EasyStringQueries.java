package com.interviewbit.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Capillary_EasyStringQueries {

  public static void main(String args[]) throws Exception {
    new Capillary_EasyStringQueries().init();
  }

  private void init() throws IOException {
    MyScanner sc = new MyScanner(System.in);
    int tests = sc.nextInt();

    while (tests-->0){
      int n = sc.nextInt();
      int q = sc.nextInt();
      //System.out.println("--");
      String input = sc.next();
      for(int i=0;i<q;i++){

        printing(((Integer)i).toString());
        int type = sc.nextInt();
        if(type == 1){
          int L = sc.nextInt();
          int R = sc.nextInt();
          int K = sc.nextInt();
          printing(L +","+ R+","+K);
          printAllSubStringsWithKDifference(input,L,R,K);
        }
        if(type == 2){
          int id = sc.nextInt();
          char ch = sc.next().charAt(0);
          printing(id+","+ch);
          printing(input);
          input = modifyStringWithNewVal(input,id-1,ch);
          printing(input);
        }
      }
    }

  }

  private String modifyStringWithNewVal(String input, int id, char ch) {
    StringBuilder stringBuilder  = new StringBuilder();
    for (int i = 0;i<input.length();i++){
      if(i == id){
        stringBuilder.append(ch);
      }
      else {
        stringBuilder.append(input.charAt(i));
      }
    }
    return stringBuilder.toString();
  }

  private void printAllSubStringsWithKDifference(String input, int l, int r, int k) {
    String str = input.substring(l - 1, r);
    //System.out.println("SUBSTRING " + str);
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length(); j++) {
        //System.out.println(str.charAt(i)+"--"+str.charAt(j));
        if(Math.abs(str.charAt(i)-str.charAt(j)) == k){
          //System.out.println("-->"+str.charAt(i)+"--"+str.charAt(j));
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private void printing(String s) {
    //System.out.print("||"+s);
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
