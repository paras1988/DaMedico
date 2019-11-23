package com.interviewbit.linkedList.pointermove;

import com.interviewbit.linkedList.list2pointer.ListNode;

public class ReverseLinkListII {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode res = new ReverseLinkListII().reverseBetween(a,1,1);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {

        int ount = 1;
        ListNode start = null;

        ListNode head1 = A;
        ListNode head = A;

        if(B==C){
            return head;
        }
        while (A.next!=null){
            if(ount == B){
                start = A;
                break;
            }
            else {
                head1 = A;
            }
            A = A.next;
            ount++;
        }

        ListNode curr = A.next;
        ListNode prev = A;
        ListNode temp = null;

        while (A.next!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

            C--;
            if(B == C){
                if(B == 1){
                    head = prev;
                }
                else{
                    head1.next = prev;
                }
                break;
            }
            A = A.next;
        }
        start.next = temp;
        return head;
    }
}
