package com.interviewbit.heap_treeMap;

import com.interviewbit.linkedList.list2pointer.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(3);

        a1.next = b1;
        b1.next = c1;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(2);

        a2.next = b2;


        ArrayList<ListNode> arr = new ArrayList<>();
        arr.add(a);
        arr.add(a1);
        arr.add(a2);

        System.out.println(new MergeKSortedLists().mergeKLists(arr));
        System.out.println("");
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> ls = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                Integer a = o1.val;
                Integer b = o2.val;
                return a.compareTo(b);
            }
        });

        for(int i=0;i<a.size();i++){
            ls.add(a.get(i));
        }

        ListNode rs = null;
        ListNode tmp = null;

        while(!ls.isEmpty()){
            ListNode t = ls.poll();
            if(t.next!=null){
                ls.add(t.next);
            }
            if(rs == null){
                rs = new ListNode(t.val);
                tmp = rs;
            }
            else {
                tmp.next = new ListNode(t.val);
                tmp = tmp.next;
            }
        }
        return rs;
    }
}
