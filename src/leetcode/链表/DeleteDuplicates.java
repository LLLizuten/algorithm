package leetcode.链表;

import java.util.HashSet;

/**
 * @author lzy
 * @create 2022-03-17 14:54
 * 83.删除排序链表中的重复元素
 * 给定一个已排序的链表的头节点,删除所有重复元素后,返回已排序链表
 */
public class DeleteDuplicates {

    /**
     * 利用指针
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //当 cur.val 和 cur.next.val 相等时说明需要去重，则将 cur 的下一个指针指向下一个的下一个，这样就能达到去重复的效果
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                //如果不相等则 cur 移动到下一个位置继续循环
                cur = cur.next;
            }
        }
        return head;
    }
}
