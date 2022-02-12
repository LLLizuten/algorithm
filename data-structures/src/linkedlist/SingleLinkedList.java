package linkedlist;

import org.junit.Test;

import java.util.LinkedList;

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
                break;
            }else {
                temp = temp.next;
                index++;
            }
        }
        if (searchIndex == index){
            return temp;
        }else {
            return null;
        }

    }

    /**
     * 获取链表长度
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
     * 遍历一遍获取链表长度index
     * 倒数第k个即为size + 1 - k的值
     */
    public HeroNode getReversedIndex(int index){
        if (head.next == null){
            return null;
        }

        int size = getLength();
        //判断index值的合理性
        if (index <= 0 || index > size){
            return null;
        }
        return searchByIndex(size + 1 - index);
    }

    /**
     * 腾讯面试题
     * 单链表反转
     * 链表的改动直接基于指针,因此可以不要返回值
     * 思路:创造一个辅助链表用于反转
     *
     * 定义一个新的头节点作为辅助链表的头节点
     * 遍历链表,将每个节点插入辅助链表的最前端,得到反转后的链表
     * 将原链表头指针指向辅助链表,链表反转完成
     */
    public void reverseList(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个新的头节点作为辅助链表的头节点
        HeroNode newHead = new HeroNode(0, "", "");
        //定义一个辅助指针,遍历原来的链表
        HeroNode temp = head.next;
        //指向当前节点的下一节点,用来判断原链表是否遍历到最后一个节点
        HeroNode next = null;
        while (temp != null){
            //先保存当前指针所在节点的下一个节点,用于遍历顺利进行
            next = temp.next;
            //当前遍历节点的下一节点为辅助链表中最前面的节点,保证每次插入的节点都在辅助链表的最前面
            temp.next = newHead.next;
            //辅助链表的头节点指向当前遍历到的节点
            newHead.next = temp;
            //指针后移
            temp = next;
        }
        head.next = newHead.next;

    }

    /**
     * 百度面试题
     * 从尾到头打印单链表
     * 利用栈先入后出的特性即可
     */


    /**
     * 合并两个有序链表,合并后依然有序
     * 利用递归
     */


}

