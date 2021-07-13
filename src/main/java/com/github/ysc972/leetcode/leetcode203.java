package com.github.ysc972.leetcode;

/**
 *
 *  删除链表 元素
 *
 */

public class leetcode203 {


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            while (head != null && head.val == val){
                head = head.next;
            }

            if(head == null){
                return head;
            }

            ListNode cur = head;
            while (cur != null){
                ListNode temp = cur.next;

                while (temp != null && temp.val == val ){
                    temp = temp.next;
                }
                cur.next = temp;
                cur = temp;

            }
            return head;
        }
    }



}
