package com.interviewbit.checkpoint;

import com.interviewbit.linkedList.list2pointer.ListNode;

public class Subtract {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode res = new Subtract().subtract(a);
        System.out.println(res);
        a = new ListNode(1);
        b = new ListNode(2);
        c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        res = new Subtract().subtract(a);
        System.out.println(res);
    }

    public ListNode subtract(ListNode A) {
        if(A==null || A.next == null){
            return A;
        }

        ListNode temp = A;

        ListNode mid = getMiddle(A);
        mid.next = reverse(mid.next);
        ListNode temp2 = mid;

        mid = mid.next;
        while (mid != null){
            temp.val = mid.val - temp.val;
            temp = temp.next;
            mid = mid.next;
        }
        temp2.next = reverse(temp2.next);
        return A;
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode sec = head.next;
        head.next = null;
        ListNode rest = reverse(sec);
        sec.next = head;
        return rest;
    }

    private ListNode getMiddle(ListNode a) {
        ListNode temp =a;
        while (a!=null && a.next != null && a.next.next!=null){
                a = a.next.next;
                temp = temp.next;
        }
        return temp;
    }
}
