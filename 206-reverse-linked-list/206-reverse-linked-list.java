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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null; 
        ListNode current = head;
        ListNode pre = null;
        ListNode next = current.next;
        while(current!= null){
            current.next = pre;
            pre = current;
            current = next;
            if(next!= null) next = next.next;
        }
        return pre;
    }
}