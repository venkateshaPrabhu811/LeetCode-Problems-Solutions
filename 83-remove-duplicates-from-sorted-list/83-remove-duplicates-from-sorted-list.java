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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if(curr == null || curr.next == null){
            return head;
        }
        int value = curr.val;
        ListNode prev = curr;
        curr = curr.next;
        while(curr != null){
            if(curr.val != value){
                value = curr.val;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = curr;
        return head;
    }
}