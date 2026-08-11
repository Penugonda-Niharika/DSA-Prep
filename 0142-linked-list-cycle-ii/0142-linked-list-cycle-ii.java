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
       ListNode t = head;
       Set<ListNode> visited = new HashSet<>();

       while(t != null) 
       {
        if(visited.contains(t)) return t;
        visited.add(t);
        t = t.next;
       }
        return null;
    }
}