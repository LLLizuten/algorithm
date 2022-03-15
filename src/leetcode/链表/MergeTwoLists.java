package leetcode.链表;

/**
 * @author lzy
 * @create 2022/3/15
 * 21.合并两个有序链表
 * 将两个升序链表合并成一个新的升序链表并返回
 *
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode temp3 = list3;
        while (temp1 != null && temp2 != null){
            if (temp1.val < temp2.val) {
                temp3.next = temp1;
                temp1 = temp1.next;
            }else {
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }
        while (temp1 != null) {
            temp3.next = temp1;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }
        while (temp2 != null){
            temp3.next = temp2;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }
        //头节点为0,因此返回头节点的下一个节点
        return list3.next;
    }
}

