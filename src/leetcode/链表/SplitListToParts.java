package leetcode.链表;

/**
 * @author lzy
 * @create 2022-03-22 19:59
 * 725.分隔链表
 * 给定一个单链表的头节点head和一个整数k
 * 将链表分隔为k个连续的部分
 * 每个部分长度差距<=1
 * 排在前面部分的长度>=后面部分的长度
 * 返回一个由上述k部分组成的数组
 *
 * 思路:
 * 计算出每个部分的长度后进行分隔
 * 须想出分隔的依据
 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        //每个部分的平均长度
        int quotient = n / k;
        //长度无法整除k时,多出来的部分的个数为remainder
        int remainder = n % k;

        //开始进行分隔操作
        ListNode cur = head;
        ListNode[] parts = new ListNode[k];
        //先分隔前remainder个较长的节点
        for (int i = 0; i < k && cur != null; i++) {
            //每次循环时,cur都指向数组该部分的第一个节点
            parts[i] = cur;
            //记录当次cur指针要跨越的长度
            int partSize = quotient;
            //如果i所处循环还在需要+1的前remainder个部分,则partSize+1
            if (i < remainder){
                partSize += 1;
            }
            //cur向后移动partSize步
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            //记录cur的下一个节点
            ListNode next = cur.next;
            cur.next = null;
            //cur后移,同时也是循环结束的条件之一
            cur = next;
        }
        return parts;
    }
}
