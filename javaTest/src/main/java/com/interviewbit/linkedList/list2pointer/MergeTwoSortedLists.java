package com.interviewbit.linkedList.list2pointer;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(8);
        ListNode f = new ListNode(22);
        ListNode g = new ListNode(42);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode a2 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode c2 = new ListNode(16);
        ListNode d2 = new ListNode(16);
        ListNode e2 = new ListNode(22);

        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;

        ListNode res = new MergeTwoSortedLists().mergeTwoLists(a,a2);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        ListNode head = null;
        ListNode curr = null;

        while (A!=null && B!=null){
            if(A.val < B.val){
                if(head == null){
                    head = A;
                    curr = A;
                }
                else{
                    curr.next = A;
                    curr = curr.next;
                }
                A = A.next;
            }
            else{
                if(head == null){
                    head = B;
                    curr = B;
                }
                else{
                    curr.next = B;
                    curr = curr.next;
                }
                B = B.next;
            }
        }

        if (A!=null){
            if(head == null){
                head = A;
            }
            else{
                curr.next = A;
            }
        }

        if (B!=null){
            if(head == null){
                head = B;
            }
            else{
                curr.next = B;
            }
        }

        return head;
    }
}
/*Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20
  4 -> 11 -> 15 - 23- 434
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
*/