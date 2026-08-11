/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode f = head, s = head;

       while(f!=null && f.next!=null) {
        f = f.next.next;
        s = s.next;
        if(f == s) {
            s = head;
            while(f != s) {
                f = f.next;
                s = s.next;
            }
            return s;
        }
       }
       return null;
    }
}