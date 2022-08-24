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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2 ==null ) return  null;
        ListNode temp  = new ListNode(0);
        ListNode t = temp;
        l1 = reverse(l1);
        l2 = reverse(l2);
        String l1values = "";
        String l2values = "";
        while(l1!=null){
            l1values+=l1.val;
            l1 = l1.next;
        }
         while(l2!=null){
            l2values+=l2.val;
            l2 = l2.next;
        }
        BigInteger l1Int = new BigInteger(l1values);
        BigInteger l2Int = new BigInteger(l2values);
        BigInteger result = l1Int.add(l2Int);
        BigInteger val10 = new BigInteger("10");
        BigInteger stopping = new BigInteger("0");
        while(true){
            temp.next = new ListNode((result.mod(val10)).intValue());
            result = result.divide(val10);
            temp = temp.next;
            if(result.equals(stopping)) break;
        }
        return t.next;
    }
    ListNode reverse(ListNode node){
        if(node ==null) return node;
        ListNode temp = node;
        ListNode prev = null;
        ListNode next = temp.next;
        while(temp!=null){
            temp.next = prev;
            prev = temp;
            temp = next;
            if(next!= null) next = next.next;
        }
        return prev;
    }
}