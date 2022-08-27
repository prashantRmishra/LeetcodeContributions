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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // we will use fast and slow pointers for solving this problem 
        //for avoiding edge case if there is only one node in the linkedList
        ListNode start = new ListNode();
        start.next = head; // by this way we are ensuring that length of the list is atleast 2
        ListNode fast = start;
        ListNode slow = start;
        for(int i =1;i<=n;++i){
            fast =fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}