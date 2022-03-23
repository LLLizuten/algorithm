package leetcode.链表;

/**
 * @author lzy
 * @create 2022-03-22 22:32
 * 328.奇偶链表
 * 给定单链表头节点head,将所有索引为奇数的节点和索引为偶数的节点分成两组并组合在一起,然后返回重组后的链表
 * 索引从1开始
 * 偶数组和奇数组内部的相对顺序应该与输入时保持一致
 *
 * 原始链表的头节点(head)也是奇数链表的头节点和结果链表的头节点
 * head的下一个节点也是偶数链表的头节点,可记作evenHead
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        //偶数链表的头节点
        ListNode evenHead = head.next;
        //定义两个指针,初始分别指向奇数链表的头节点和偶数链表的头节点
        ListNode odd = head;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            //更新奇数节点
            odd.next = even.next;
            odd = odd.next;
            //更新偶数节点
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;

    }
}
