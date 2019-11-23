package com.interviewbit.arrays.ValueRanges;

import java.util.ArrayList;


/*
* Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
*/
public class MergeOverlappingIntervals_2 {

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

        ArrayList<Interval> res=new MergeOverlappingIntervals_2().merge(arr);
        System.out.println(res.size());
    }

    private ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<>();

        res.add(intervals.get(0));

        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start <= res.get(res.size()-1).end){
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end,intervals.get(i).end);
            }
            else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }

}
