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
    public ListNode swapNodes(ListNode head, int k) {
        /*List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        int left = list.get(k-1);
        int right = list.get(list.size() - k);
        list.set(k-1,right);
        list.set(list.size() - k,left);
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for(int i = 0;i<list.size();i++){
            ListNode node = new ListNode(list.get(i));
            curr.next = node;
            curr = node;
        }
        return dummy.next;*/
        ListNode left = head;
        ListNode right = head;
        ListNode curr = head;
        int counter = 1;
        while(curr != null){
            if(counter < k){
                left = left.next;
            }
            if(counter > k){
                right = right.next;
            }
            curr = curr.next;
            counter++;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}