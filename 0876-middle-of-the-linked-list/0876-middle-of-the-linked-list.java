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
    public ListNode middleNode(ListNode head) {
        int c = 0,mid = 0;
        ListNode t = head;
        while(t.next != null) {
            c++;
            t = t.next;
        }
        if(c%2 == 0) mid = c/2;
        else mid = (c/2)+1;
        t = head;
        while(mid>0) {
            t = t.next;
            mid--;
        }
        return t;
    }
}