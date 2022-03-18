package leetcode.链表;

/**
 * @author lzy
 * @create 2022-03-18 20:26
 * 给定一个区间[m,n],索引从1开始,反转区间中的链表元素
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n){
        //m=1,即为反转前n个节点
        if (m == 1) {
            return ReverseN.reverse(head,n);
        }

        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
