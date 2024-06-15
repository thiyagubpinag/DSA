package LinkedList;

public class RotateList {

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
    public ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Count the number of nodes in the list
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        // Handle the case where k is greater than or equal to the number of nodes
        k = k % count;

        // Find the kth node from the end
        temp = head;
        for (int i = 0; i < count - k - 1; i++) {
            temp = temp.next;
        }

        // Get the new head and tail nodes
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode newTail = head.prev;

        // Connect the end of the rotated list to the original head
        newTail.next = head;
        head.prev = newTail;

        // Connect the new head to the original tail
        newHead.prev = null;

        // Return the new head of the rotated list
        return newHead;
    }
}