package top100;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author lzy
 * @create 2021-12-01 23:01
 * 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 递归
 * 终止条件：当两个链表都为空时，表示我们对链表已合并完成。
 * 如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
 */
public class CombineTwoOrderedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //先创造一个带头节点的新链表(l3本身就是头节点)
        ListNode l3 = new ListNode();
        //辅助指针
        ListNode p = l3;
        //同时遍历两个链表
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }

            p = p.next;
        }

        if (list1 != null){
            p.next = list1;
        }else if (list2 != null){
            p.next = list2;
        }
        return l3.next;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(l1);

        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println(l3);


    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */