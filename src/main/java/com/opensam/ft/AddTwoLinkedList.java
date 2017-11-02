package com.opensam.ft;

public class AddTwoLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = (l1.val+l2.val);
        int carry = sum/10;
        ListNode node = new ListNode(sum%10);
        ListNode iter = node;
        while((l1.next!=null || l2.next!=null) || carry == 1) {
            sum = (l1.next==null?0:l1.next.val) + (l2.next==null?0:l2.next.val)+carry;
            ListNode currNode = new ListNode((sum)%10);
            carry = sum/10;
            iter.next = currNode;
            iter = currNode;
            l1=(l1.next==null?l1:l1.next);
            l2=(l2.next==null?l2:l2.next);
        }
        return node;
    }
}




