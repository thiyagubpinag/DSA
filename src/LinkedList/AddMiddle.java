package LinkedList;

class AddMiddle {

    // Definition for doubly-linked list.
    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int size = 0;

    public static ListNode addVal(ListNode head, int val) {
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        addInMid(head, val);
        ListNode frontNode = new ListNode(val);
        ListNode lastNode = new ListNode(val);
        frontNode.next = head;
        head = frontNode;
        temp.next = lastNode;
        return head;

    }

    //addInMid() will add a node to the middle of the list
    public static void addInMid(ListNode head, int data) {
        //Create a new node
        ListNode newNode = new ListNode(data);

        //If list is empty
        if (head == null) {
            head = newNode;
        } else {
            //current will point to head
            ListNode current = head;
            ListNode temp = null;

            //Store the mid position of the list
            int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);

            //Iterate through list till current points to mid position
            for (int i = 1; i < mid; i++) {
                current = current.next;
            }

            //Node temp will point to node next to current
            temp = current.next;
            temp.prev = current;

            //newNode will be added between current and temp
            current.next = newNode;
            newNode.prev = current;
            newNode.next = temp;
            temp.prev = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        ListNode newNode1 = new ListNode(1);
        ListNode newNode2 = new ListNode(2);
        newNode1.next = newNode2;
        addVal(newNode1, 5);
    }
}