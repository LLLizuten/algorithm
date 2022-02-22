package linkedlist;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lzy
 * @create 2021-11-30 12:00
 * 单链表
 */
public class SingleLinkedList {
    /**
     * 头节点,指向第一个节点的位置
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        //头节点不动,需要一个辅助指针temp
        HeroNode temp = head;
        //遍历链表,使指针到达最后一个位置,当退出循环时,指针到达链表最后
        while (temp.next != null) {
            temp = temp.next;
        }

        //将传入的节点作为下一个新节点
        temp.next = heroNode;
    }

    /**
     * 根据id值添加节点
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        //标识节点,判断传入对象的id值是否重复
        boolean flag = false;
        while (temp.next != null){
            if (temp.next.id > heroNode.id){
                break;
            }else if (temp.next.id == heroNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            System.out.println("编号已存在,无法添加");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    /**
     * 遍历链表
     */
    public void list(){
        //先判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //辅助指针:指向头节点所指的下一个节点(头节点不储存数据)
        HeroNode temp = head.next;

        while (temp != null) {
            //输出节点信息,指针后移
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 返回链表第一个节点
     */
    public HeroNode getFirst(){
        if (head.next == null){
            return null;
        }

        return head.next;
    }
    /**
     * 查找第k个节点
     * index从1开始
     */
    public HeroNode searchByIndex(int searchIndex){
        if (head == null){
            return null;
        }

        HeroNode temp = head.next;
        int index = 1;
        while (temp != null){
            if (searchIndex == index){
                return temp;
                //break;
            }else {
                temp = temp.next;
                index++;
            }
        }
        return null;
//        if (searchIndex == index){
//            return temp;
//        }else {
//            return null;
//        }

    }

    /**
     * 获取链表长度(不包含头节点)
     */
    public int getLength(){
        if (head.next == null){
            return 0;
        }
        HeroNode temp = head;
        int length = 0;
        while (temp.next != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 新浪面试题
     * 查找单链表中倒数第k个节点    (新浪面试题)
     * 思路
     * 遍历一遍获取链表长度length
     * 倒数第k个即为size + 1 - k的值
     */
    public HeroNode getReversedIndex(int k){
        if (head.next == null){
            return null;
        }
        int length = getLength();
        //判断长度合理性
        if (k <= 0 || k > length){
            return null;
        }
        return searchByIndex(length + 1 - k);
    }

    /**
     * 腾讯面试题
     * 单链表反转
     * 链表的改动直接基于指针,因此可以不要返回值
     * 思路:创造一个辅助链表用于反转
     *
     * 定义一个新的头节点作为辅助链表的头节点
     * 遍历链表,将每个节点插入辅助链表的最前端,得到反转后的链表(头插法)
     * 将原链表头指针指向辅助链表,链表反转完成
     */
    public void reverseList(){
        if (head.next == null || head.next.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个新的头节点作为辅助链表的头节点
        HeroNode newHead = new HeroNode(0, "", "");

        //定义一个辅助指针用于遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点的下一节点,用于辅助头插
        HeroNode next = null;
        /**
         * 遍历原来的链表,每遍历一个节点,将其取出,用头插法放在新链表的最前端
         * 此部分理解建议画图,画图后豁然开朗
         */
        while (cur != null){
            //用于暂时保存当前节点的下一节点,保证之后的遍历继续进行
            next = cur.next;
            //当前节点的下一节点指向新链表中最前面的节点(头插法),此时原链表断开,上面的next即将发挥作用
            cur.next = newHead.next;
            //新链表的头节点指向当前节点,完成当前节点的插入
            newHead.next = cur;
            //指针后移,遍历继续(next发挥作用)
            cur = next;

        }
        head.next = newHead.next;
    }

    /**
     * 百度面试题
     * 从尾到头打印单链表
     * 利用栈先入后出的特性即可
     *
     */
    public void reversePoint(){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序链表,合并后依然有序
     * 有问题，会出现无限循环，暂未找到原因
     */
    public SingleLinkedList mergerLinkedList(SingleLinkedList l1, SingleLinkedList l2){
        if (l1.head.next == null){
            return l2;
        }else if (l2.head.next == null){
            return l1;
        }

        SingleLinkedList mergeList = new SingleLinkedList();
        HeroNode temp1 = l1.head.next;
        HeroNode temp2 = l2.head.next;
        HeroNode temp3 = mergeList.head;
        while (temp1 != null && temp2 != null){
            if (temp1.id <= temp2.id){
                mergeList.add(temp1);
                temp1 = temp1.next;
            }else {
                mergeList.add(temp2);
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }

        while (temp2 != null){
            mergeList.add(temp2);
            temp2 = temp2.next;
        }

        while (temp1 != null){
            mergeList.add(temp1);
            temp1 = temp1.next;
        }
        return mergeList;
    }


}

