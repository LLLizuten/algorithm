package leetcode.双指针;


/**
 * @author lzy
 * @create 2022-03-10 15:59
 * 141.环形链表
 * 给你一个链表的头节点head,判断链表中是否有环
 * 双指针技巧中的快慢指针
 * 慢指针前进一步,快指针前进两步;若快指针最后指向空,说明无环;若两指针相遇,说明有环
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(-4);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l2;
        System.out.println(new HasCycle().hasCycle(head));


    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //因为快指针一次走两步,会更早遇到空指针情况,需要在快指针遇到空指针情况时及时结束循环
        //快指针可能在上一次循环前进两步后就已经是空指针了
        while (fast != null  && fast.next != null){
            //慢指针走一步,快指针走两步
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}