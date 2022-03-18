package leetcode.链表;

/**
 * @author lzy
 * @create 2022/3/15
 * 206.链表反转
 *  双指针迭代
 */
public class ReverseList {
    /**
     * 双指针迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = new ListNode();
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归
     */
    public ListNode reverseList2(ListNode head) {
        //终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
