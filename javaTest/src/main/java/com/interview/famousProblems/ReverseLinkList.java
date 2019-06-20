package com.interview.famousProblems;

public class ReverseLinkList {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);

        node.next = node1;
        node1.next = node2;

        Node res  = reverse(node);
        System.out.println(res);
    }

    private static Node reverse(Node head) {
        if(head.next == null){
            return head;
        }
        Node sec = head.next;
        head.next = null;
        Node rest = reverse(sec);
        sec.next = head;
        return rest;
    }
}

class Node{
    Node(int data){
        this.data  = data;
    }
    Node next;
    int data;
}