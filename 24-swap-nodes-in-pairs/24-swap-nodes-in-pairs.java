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

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next ==null) return head;
        int count =1;
        ListNode prev = null;
        ListNode temp = head;
        ListNode list = new ListNode(0);
        ListNode l = list;
        while(temp!=null){
            if(count % 2!=0){
                prev = temp;
                count++;
            }
            else{
                list.next = new ListNode(temp.val);
                list = list.next;
                list.next = new ListNode(prev.val);
                list = list.next;
                count++;
            }
            temp = temp.next;
        }
        //if the length of the head list is odd then count value at the end would be even as only if block will be executed.
        if(count%2 ==0){
            list.next  = new ListNode(prev.val);
            list = list.next;
        }
        
        return l.next;
    }
}