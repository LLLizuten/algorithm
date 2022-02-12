package top100;

import org.junit.Test;

/**
 * @author lzy
 * @create 2021-12-01 22:39
 * 19 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * n >= 1
 *
 * 思路
 * 遍历获取长度size
 * 倒数第n个-->size + 1 - n
 * ......
 */
public class DeleteTheNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //获取链表长度,默认长度为0
        int size = 0;
        while (head != null){
            head = head.next;
            size++;
        }

        return null;
    }


    @Test
    public void test(){
        ListNode listNode = new ListNode();
        System.out.println(listNode);
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "[" +
                val +
                 next +
                ']';
    }
}