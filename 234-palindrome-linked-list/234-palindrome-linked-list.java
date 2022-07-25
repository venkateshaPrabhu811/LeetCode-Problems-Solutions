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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> q = new ArrayDeque<>();
        while(head != null){
            q.add(head.val);
            head = head.next;
        }
        while(q.size() > 1){
            if(q.pollFirst() != q.pollLast()) return false;
        }
        return true;
    }
}