package queue;

public class SplitAlternatingNodes {
    static class Node {
        int value;
        Node next;

        Node(int val) {
            value = val;
            next = null;
        }
    }

    public static Node[] splitAlternatingNodes(Node head) {
        Node odd = new Node(-1);
        Node even = new Node(-1);
        Node oddTemp = odd;
        Node evenTemp = even;

        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            oddTemp.next = new Node(temp.value);
            evenTemp.next = new Node(temp.next.value);
            temp = temp.next.next;
            oddTemp=oddTemp.next;
            evenTemp=evenTemp.next;
        }
        if (temp != null) {
            oddTemp.next = new Node(temp.value);
        }
        if (temp.next != null) {
            evenTemp.next = new Node(temp.next.value);
        }

        return new Node[]{odd.next, even.next};
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);


        splitAlternatingNodes(node);

    }
}
