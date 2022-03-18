package leetcode.链表;

/**
 * @author lzy
 * @create 2022-03-18 19:50
 * 反转链表前n个节点
 */
public class ReverseN {
    /**
     * 定义一个后驱节点
     */
    static ListNode successor = null;
    public static ListNode reverse(ListNode head, int n) {
        //终止条件:当n == 1时,记录后驱节点
        if (n == 1) {
            //head.next = successor;
            successor = head.next;
            return head;
        }

        //本层递归:从下一个节点开始递归,反转前n - 1个节点  返回值:返回调转后的链表
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(12);
        ListNode l2 = new ListNode(43);
        ListNode l3 = new ListNode(16);
        ListNode l4 = new ListNode(52);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode temp = l1;
        while (temp != null) {
            System.out.print(temp.val + "--->");
            temp = temp.next;
        }
        System.out.println();

            ListNode temp2 = ReverseN.reverse(l1, 3);
        while (temp2 != null) {
            System.out.print(temp2.val + "--->");
            temp2 = temp2.next;
        }

    }
}
