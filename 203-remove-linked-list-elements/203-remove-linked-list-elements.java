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
    public ListNode removeElements(ListNode head, int ele) {
        ListNode extra = new ListNode();
        extra.next = head;
        ListNode curr = head;
        ListNode prev = extra;
        if(head==null) return head;
        while(curr!= null){
            if(curr.val == ele){
                prev.next = curr.next;
                curr = prev.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return extra.next;
    }
}