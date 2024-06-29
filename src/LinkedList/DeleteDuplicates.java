package LinkedList;

public class DeleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (prev != null && prev.val== temp.val) {
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode newNode1 = new ListNode(1);
        ListNode newNode2 = new ListNode(1);
        ListNode newNode3 = new ListNode(2);
        newNode1.next = newNode2;
        newNode2.next=newNode3;
        deleteDuplicates(newNode1);
    }
}
