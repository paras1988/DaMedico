package com.interviewbit.linkedList.listmath;

import com.interviewbit.linkedList.list2pointer.ListNode;

public class ListCycle {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode a) {

        ListNode curr = a;
        ListNode dcurr = a;
        Boolean isloop = false;

        while (curr!=null && dcurr.next!=null && dcurr.next.next != null){
            curr = curr.next;
            dcurr = dcurr.next.next;

            if(curr == dcurr){
                isloop = true;
                break;
            }
        }

        if(!isloop){
            return null;
        }
        while (curr != a){
            a = a.next;
            curr = curr.next;
        }
        return curr;
    }
}

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.

Example :
Input :
                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.
*/