package leetcode.链表;

/**
 * @author lzy
 * @create 2022-03-18 20:57
 *
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //定义一个指针node,用于从头遍历链表;下一节点指向head
        ListNode node = new ListNode();
        node.next = head;
        //定义node的辅助指针
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            //一系列交换
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;
            //辅助指针pre后移
            pre = l1;
        }
        return node.next;
    }
}
