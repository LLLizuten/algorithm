package leetcode.链表;

import java.util.Stack;

/**
 * @author lzy
 * @create 2022-03-19 14:31
 * 445.两数相加
 * 给定两个非空链表来代表两个非负整数，将两数相加返回一个新链表
 * 利用栈先入后出的特性完成加法的计算
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        //定义一个进位器，用于加法的进位计算
        int carry = 0;
        //定义一个空节点,用于反转链表
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            //res初始=carry的值,保证在s1和s2都空的情况下也能加上进位的值
            int res = carry;
            res += s1.isEmpty() ? 0 : s1.pop();
            res += s2.isEmpty() ? 0 : s2.pop();
            //存放本位计算结果,注意取余
            ListNode node = new ListNode(res % 10);
            //反转链表
            node.next = head;
            head = node;

            carry = res / 10;
        }
        return head;
    }

    /**
     * 自己的思路,存在错误
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        //定义一个进位器，用于加法的进位计算
        int carry = 0;
        //用于存放每一次的运算结果
        ListNode list = new ListNode();
        int res = 0;
        while (!s1.isEmpty() && !s2.isEmpty()){
            int n1 = s1.pop();
            int n2 = s2.pop();
            res = n1 + n2 + carry;
            if (res >= 10) {
                res = res % 10;
                carry = 1;
            }else {
                res += carry;
                carry = 0;
            }
            list.next = new ListNode(res);
        }
        while (!s1.isEmpty()) {
            res = s1.pop() + carry;
            carry = 0;
        }
        while (!s2.isEmpty()) {
            res = s2.pop() + carry;
            carry = 0;
        }
        return reverse(list);

    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = cur;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
