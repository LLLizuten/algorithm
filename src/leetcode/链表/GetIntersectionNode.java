package leetcode.链表;

/**
 * @author lzy
 * @create 2022/3/14
 * 160.相交链表
 * 已知两单链表的头节点headA和headB
 * 找出并返回两链表相交的起始节点的值,没有则返回null
 * 返回结果后,链表必须保持其原始结构
 *
 * 思路
 * 如果两链表相交,相交点后的长度(c)是相同的
 * 即a + c = b + c
 * 让两链表走完各自路径后,再接着走另一条链表
 * 如果相交,最终的总路径一致,会在相交点会和       a+c+b = b+c+a
 * 如果不相交,则最后都在null
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA == null){
                tempA = headB;
            }else {
                tempA = tempA.next;
            }
            if (tempB == null) {
                tempB = headA;
            }else {
                tempB = tempB.next;
            }
        }
        return tempA;
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
}
