package com.interviewbit.arrays.ValueRanges;

import java.util.ArrayList;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> arr=new ArrayList<Interval>();
        Interval i1=new Interval(1,3);
        Interval i2=new Interval(2,6);
        Interval i3=new Interval(8,10);
        Interval i4=new Interval(9,18);
        Interval i5=new Interval(15,17);
        Interval i6=new Interval(16,18);
        arr.add(i1);
        arr.add(i2);
        arr.add(i3);
        arr.add(i4);
        arr.add(i5);
        arr.add(i6);

        ArrayList<Interval> res=new MergeOverlappingIntervals().merge(arr);
        System.out.println(res.size());
    }

    private ArrayList<Interval> merge(ArrayList<Interval> arr) {
        ArrayList<Interval> res = new ArrayList<>();
        Interval curr = arr.get(0);
        for(int i=1;i<arr.size();i++){
            Interval a = merge(curr, arr.get(i));
            if(a==null){
                res.add(curr);
                curr = arr.get(i);
            }
            else{
                curr = a;
            }
        }
        res.add(curr);
        return res;
    }

    private Interval merge(Interval curr, Interval interval) {
        if(curr.end<interval.start){
            return null;
        }
        return new Interval(curr.start,Math.max(curr.end,interval.end));
    }
}
