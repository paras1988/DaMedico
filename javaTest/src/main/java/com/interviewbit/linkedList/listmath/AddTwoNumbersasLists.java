package com.interviewbit.linkedList.listmath;

import com.interviewbit.linkedList.list2pointer.ListNode;

public class AddTwoNumbersasLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        ListNode res = new AddTwoNumbersasLists().addTwoNumbers(a,d);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode head = null;
        ListNode curr = null;

        int cf = 0;
        while (A!=null && B!=null){
            int val = A.val + B.val + cf;
            cf = val/10;
            if(head == null){
                head = new ListNode(val%10);
                curr = head;
            }
            else{
                curr.next =  new ListNode(val%10);
                curr = curr.next;
            }
            A = A.next;
            B = B.next;
        }

        while (A!= null){
            int val = A.val + cf;
            cf = val/10;
            if(head == null){
                head = new ListNode(val%10);
                curr = head;
            }
            else{
                curr.next =  new ListNode(val%10);
                curr = curr.next;
            }
            A = A.next;
        }

        while (B!= null){
            int val = B.val + cf;
            cf = val/10;
            if(head == null){
                head = new ListNode(val%10);
                curr = head;
            }
            else{
                curr.next =  new ListNode(val%10);
                curr = curr.next;
            }
            B = B.next;
        }
        if(cf == 1){
            curr.next =  new ListNode(1);
        }
        return head;
    }
}
