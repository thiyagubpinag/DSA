package queue;

public class MaxElement {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(6);
        node.next.next.next.next=new Node(8);
        printList(node);
    }

    public static void printList(Node head) {
        int max=Integer.MIN_VALUE;
        Node temp=head;
        while(temp!=null){
            max=Math.max(max,temp.data);
            temp=temp.next;
        }
        System.out.println(max);
    }
}
