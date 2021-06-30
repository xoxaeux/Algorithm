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
        if(l1 == null && l2 == null) return null;
        if(l1 == null){
            return new ListNode(l2.val, l2.next);
        }
        if(l2 == null){
            return new ListNode(l1.val, l1.next);
        }
        
        
        if(l1.val+l2.val>=10){
            if(l1.next == null && l2.next == null){
                return new ListNode((l1.val+l2.val)%10, new ListNode(1));
            }
            return new ListNode((l1.val+l2.val)%10, addTwoNumbers(new ListNode(l1.next.val+1,l1.next.next), l2.next));
        }
        return new ListNode(l1.val+l2.val, addTwoNumbers(l1.next, l2.next));
    }
}
