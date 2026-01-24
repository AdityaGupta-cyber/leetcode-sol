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

            // if (node1 != null || node2 != null) {
            //     sum = carry + node1.val + node2.val;
            //     node1 = node1.next;
            //     node2 = node2.next;
            // } else if (node1 == null) {
            //     sum = carry + node2.val;
            //     node2 = node2.next;
            // } else {
            //     sum = carry + node1.val;
            //     node1 = node1.next;
            // }

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

        // while (node1 != null) {
        //     int sum = 0;
        //     sum = carry + node1.val;
        //     node1 = node1.next;
        //     carry = sum/10;
        //     if (result == null) {
        //         result = new ListNode(sum % 10);
        //         resultHead = result;
        //     } else {
        //         result.next = new ListNode(sum % 10);
        //         result = result.next;
        //     }
        // }

        // while (node2 != null) {
        //     int sum = 0;
        //     sum = carry + node2.val;
        //     node2 = node2.next;
        //     carry = sum/10;
        //         result.next = new ListNode(sum % 10);
        //         result = result.next;
        // }

        // if (carry != 0) {
        //     result.next = new ListNode(carry);
        // }

        return resultHead.next;
    }

    // Iterate through the to linkedLists and store it into the number 
    // private int getNumberFromList(ListNode l) {
    //     int temp = 0;
    //     ListNode tempNode = l;
    //     while (tempNode.next != null) {
    //         temp = temp * 10 + l.val;
    //         tempNode = l.next;
    //     }
    //     return temp;
    // }

    // private ListNode getListFromNumber(int number) {

    //     if (number == 0) {
    //         return new ListNode(0);
    //     }

    //     ListNode listHead = null;
    //     ListNode listTail = null;
    //     while (number > 0) {
    //         if (listHead == null) {
    //             listHead = new ListNode(number);
    //             listTail = listHead;
    //         }
    //         else{
    //             listTail.next = new ListNode(number);
    //             listTail = listTail.next;
    //         }

    //         number = number / 10;
    //     }
    //     return listHead;
    // }
}