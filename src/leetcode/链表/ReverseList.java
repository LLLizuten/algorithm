package leetcode.链表;

/**
 * @author lzy
 * @create 2022/3/15
 * 206.链表反转
 *  双指针迭代
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = new ListNode();
        while (cur != null) {
            temp = cur.next;
            cur.next = temp;



        }

    }
}
