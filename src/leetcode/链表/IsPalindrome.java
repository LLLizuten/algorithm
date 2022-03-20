package leetcode.链表;

import java.util.Stack;

/**
 * @author lzy
 * @create 2022-03-20 14:33
 * 234.回文链表
 * 判断链表是否为回文链表
 */
public class IsPalindrome {
    /**
     * 利用栈先入后出的特性
     */
    public boolean isPalindrome1(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        //代替head进行遍历
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (head != null && stack.peek() != null){
            ListNode node = stack.pop();
            int val = node.val;
            if (head.val == val){
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }
    /**
     * 快慢指针
     */
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//    }
}
