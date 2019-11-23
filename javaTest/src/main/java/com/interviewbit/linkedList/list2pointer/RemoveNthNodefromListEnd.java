package com.interviewbit.linkedList.list2pointer;

public class RemoveNthNodefromListEnd {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode res = new RemoveNthNodefromListEnd().removeNthFromEnd(a,1);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

        System.out.println("----------");
        res = new RemoveNthNodefromListEnd().removeNthFromEnd(a,1);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

        System.out.println("----------");
        res = new RemoveNthNodefromListEnd().removeNthFromEnd(a,3);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }


    }

    public ListNode removeNthFromEnd(ListNode curr, int B) {

        ListNode head = curr;

        int size = 0;
        while (curr!=null){
            ++size;
            curr = curr.next;
        }

        if(size<=B){
            return head.next;
        }

        B = size-B;

        curr = head;
        while (curr!=null){
            --B;
            if(B == 0){
                if(curr.next == null){
                    curr.next = null;
                }
                else{
                    curr.next = curr.next.next;
                }
                break;
            }
            curr = curr.next;
        }
        return head;
    }
}
/*Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
*/