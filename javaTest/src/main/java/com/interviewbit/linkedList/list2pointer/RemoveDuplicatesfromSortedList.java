package com.interviewbit.linkedList.list2pointer;

public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(1);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(4);

     /*   a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;*/

        ListNode res = new RemoveDuplicatesfromSortedList().deleteDuplicates(a);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode A) {

        ListNode head = A;
        ListNode curr = A;
        int val = A.val;

        while (A.next!=null){
            if(A.next.val != val){
                curr.next = A.next;
                curr = curr.next;
                val = A.next.val;
            }
            A = A.next;
        }
        curr.next = null;
        return head;
    }
}
/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
