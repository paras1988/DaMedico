package com.interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyList {

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);

        a.next = b;
        b.next = c;

        a.random = c;
        b.random = a;
        c.random = a;

        RandomListNode res = new CopyList().copyRandomList(a);

        System.out.println(res);
    }


    public RandomListNode copyRandomList(RandomListNode head) {

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode temp = head;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode newTemp = newHead;

        map.put(head,newHead);

        while (temp.next != null){
            temp = temp.next;
            newTemp.next = new RandomListNode(temp.label);
            newTemp = newTemp.next;
            map.put(temp,newTemp);
        }

        newTemp = newHead;
        temp = head;

        while (newTemp!=null){
            newTemp.random = map.get(temp.random);
            newTemp = newTemp.next;
            temp = temp.next;
        }
        return newHead;
    }
}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

/*
* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.


* */