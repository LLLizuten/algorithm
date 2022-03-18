package leetcode.链表;

/**
 * @author lzy
 * @create 2022-03-18 13:50
 * 19.删除链表的倒数第n个节点
 * 用快慢指针和预先指针
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //head有可能是被删除的节点,所以此处用一个预先指针
        ListNode pre = new ListNode(0);
        pre.next = head;
        //快慢指针,快指针先移动,间隔为n
        ListNode fast = pre, slow = pre;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //慢指针的下一个节点即为倒数第n个节点
        ListNode temp = slow.next;
        slow.next = temp.next;
        return pre.next;
    }
}
