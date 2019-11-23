package com.interviewbit.linkedList.list2pointer;

public class RotateList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(5);

        a.next = b;
      /*  b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;*/
     /*   f.next = g;*/

        ListNode res = new RotateList().rotateRight(a,1);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
    public ListNode rotateRight(ListNode curr, int B) {
        ListNode head = curr;

        int size = 0;
        while (curr!=null){
            ++size;
            curr = curr.next;
        }

        if(size == 0){
            return head;
        }

        B = B%size;
        if(B == 0){
            return head;
        }
        B = size-B;


        ListNode head2 = null;
        curr = head;
        while (curr.next!=null){

            if(B == 1){
                head2 = curr.next;
                curr.next = null;
                curr = head2;
            }
            else{
                curr = curr.next;
            }

            --B;
        }
        curr.next = head;
        return head2;
    }

}
/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/