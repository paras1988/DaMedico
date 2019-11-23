package com.interviewbit.arrays.ValueRanges;


import java.util.ArrayList;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]
 */


// Approach: 2 cases  new interval is and overlapping and overlapping
//if non - then just fit it.
//if over - then merge to new.
public class MergeNonOverlappingIntervals_doItAgain_more_thought_Needed {

    public static void main(String[] args) {
        ArrayList<Interval> arr=new ArrayList<Interval>();
        Interval i1=new Interval(1,5);
        Interval i2=new Interval(7,10);
        Interval i3=new Interval(12,116);
        arr.add(i1);
        arr.add(i2);
        arr.add(i3);


        Interval i6=new Interval(8,111);

        ArrayList<Interval> res=new MergeNonOverlappingIntervals_doItAgain_more_thought_Needed().insert(arr,i6);

        System.out.println(res.size());

        Interval i7=new Interval(222,233);

        res=new MergeNonOverlappingIntervals_doItAgain_more_thought_Needed().insert(arr,i7);

        System.out.println(res.size());

        System.out.println("END");
    }


    public ArrayList<Interval> insert(ArrayList<Interval> intervals
            , Interval newInterval) {

        //wrong
/*
        ArrayList<Interval> result = new ArrayList<>();

        if(newInterval.end < intervals.get(0).start){
            intervals.add(newInterval);
            return intervals;
        }
        for(int i=0;i<intervals.size();i++){
            if((newInterval.start>= intervals.get(i).start && newInterval.start<= intervals.get(i).end) ||
                    (newInterval.end>= intervals.get(i).start && newInterval.end<= intervals.get(i).end)){

                newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
                        Math.max(newInterval.end, intervals.get(i).end));

                result.add(newInterval);
            }
            else{
                result.add(intervals.get(i));
            }
        }
        if(result.size()==0 || (newInterval.start > result.get(result.size()-1).end)){
            result.add(newInterval);
        }

        return result;*/

return null;
    }
}

