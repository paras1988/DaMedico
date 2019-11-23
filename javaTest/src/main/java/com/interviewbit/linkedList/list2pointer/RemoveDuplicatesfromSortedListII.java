package com.interviewbit.linkedList.list2pointer;

public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(1);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode res = new RemoveDuplicatesfromSortedListII().deleteDuplicates(a);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode A) {
        ListNode head = null;
        ListNode prev = null;
        ListNode curr = A;

        while (curr!= null){
            if (curr.next == null || curr.val != curr.next.val){
                if(prev == null){
                    head = curr;
                    prev = curr;
                }
                else{
                    prev.next = curr;
                    prev  = prev.next;
                }
                curr = curr.next;
            }
            else{
                ListNode temp = curr;
                while (temp.val == temp.next.val){
                    temp = temp.next;
                    if(temp.next == null){
                        break;
                    }
                }
                curr = temp.next;
            }
        }
        if(prev!=null){
            prev.next = curr;
        }
        return  head;
    }
}
