package com.qhm.example.test.linked.reverse;

public class SinglyLinkedListReverse {


    public static void main(String[] args) {

        Node n5 = new Node(5,null);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Node node =  reverse(n1);

        /*while(node != null){
            System.out.println(node.value);
            node = node.next;
        }*/
    }

    public static Node reverse(Node head){
        if (head == null || head.next == null)
            return head;
        //先将下一节点保存，防止节点丢失
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
