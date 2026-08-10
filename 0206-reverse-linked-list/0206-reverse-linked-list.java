/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode rev(ListNode t, ListNode p) {
        if(t == null) return p;
        ListNode f = t.next;
        t.next = p;
        p = t;
        t = f;
        return rev(t, p);
    }

    public ListNode reverseList(ListNode head) {
        return rev(head, null);
    }
}