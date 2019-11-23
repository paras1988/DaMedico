package com.interviewbit.linkedList.list2pointer;

public class PalindromeList {


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(new PalindromeList().lPalin(a));

        ListNode f = new ListNode(1);
        System.out.println(new PalindromeList().lPalin(f));
    }

    ListNode revHead = null;

    public int lPalin(ListNode A) {
        ListNode mid = A;
        ListNode head = A;

        while (head != null){
            if(head.next == null || head.next.next == null){
                break;
            }
            head = head.next.next;
            mid = mid.next;
        }

        if(mid == null || mid.next == null){
            return 1;
        }
        ListNode temp = null;
        // mid = reverseTailRecursive(mid.next, temp);
        mid = reverse3Pointer(mid.next);


        head = A;
        while (mid!=null){
            if(head.val != mid.val){
                return 0;
            }
            head = head.next;
            mid = mid.next;
        }
        return 1;
    }

    private ListNode reverse3Pointer(ListNode curr) {
        if(curr.next == null){
            return curr;
        }
        ListNode prev = null;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private ListNode reverseTailRecursive(ListNode curr, ListNode prev) {
        if(curr.next == null){
            revHead = curr;
            curr.next = prev;
            return revHead;
        }
        ListNode next  = curr.next;
        curr.next = prev;

        reverseTailRecursive(next, curr);
        return revHead;
    }


    /*

    private ListNode reverse(ListNode mid) {
        if(mid.next == null){
            revHead = mid;
            return mid;
        }
        ListNode listNode  = reverse(mid.next);
        listNode.next = mid;
        mid.next = null;

        return mid;
    }
*/
}
