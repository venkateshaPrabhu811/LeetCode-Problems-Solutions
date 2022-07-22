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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode curr1 = lesser,curr2 = greater;
        while(head != null){
            if(head.val < x){
                curr1.next = head;
                curr1 = curr1.next;
            }
            else{
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = greater.next;
        return lesser.next;
    }
}