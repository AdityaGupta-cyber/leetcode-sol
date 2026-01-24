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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Iterate through the linkedLists and carry over the sum.

        /*
        * Pseudo code
        *  all we need to do is iterate through both the linkedLists at the same time and at each node we `ADD` the values  and 
        * if the sum exceeds a single digit value then we *`carry over the tenths place to the next node sum`
        */

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode resultHead = new ListNode(-1);
        ListNode result = resultHead;
        int carry = 0;
        while (node1 != null ||  node2 != null || carry !=0) {
            int sum = 0;


            if(node1 != null ){
                sum +=  node1.val;
                node1 = node1.next;
            }
            if(node2 != null){
                sum += node2.val;
                node2 = node2.next;
            }
            sum += carry;
            carry = sum / 10;

                result.next = new ListNode(sum % 10);
                result = result.next;
            
        }


        return resultHead.next;
    }

}