package linkedlist;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author lzy
 * @create 2021-12-01 16:27
 */
public class LinkedListTest {
    @Test
    public void test(){
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(h1);
        list.addByOrder(h2);
        list.addByOrder(h3);
        list.addByOrder(h4);

        int length = list.getLength();
        System.out.println("length=" + length);
        list.list();
        list.reverseList();
        System.out.println("reverse");
        list.list();

        System.out.println("-----------");
        SingleLinkedList list2 = new SingleLinkedList();
        System.out.println("length2=" + list2.getLength());
    }

    @Test
    public void test2(){
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");
        SingleLinkedList list = new SingleLinkedList();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);

        //list.list();
        HeroNode heroNode = list.searchByIndex(1);
        System.out.println(heroNode);

        //查找倒数第二个
        HeroNode reversedIndex = list.getReversedIndex(2);
        System.out.println(reversedIndex);
    }

    /**
     * 反转链表
     */
    @Test
    public void test3(){
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");
        SingleLinkedList list = new SingleLinkedList();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);

        list.reverseList();
        list.list();
    }

    /**
     * 从尾到头打印链表
     * 利用了栈先入后出的特性
     */
    @Test
    public void test4(){
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");
        SingleLinkedList list = new SingleLinkedList();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);

        list.reversePoint();
    }

    /**
     * 合并两个有序链表，且合并后仍然有序
     */
    @Test
    public void test5(){
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");
        SingleLinkedList l1 = new SingleLinkedList();
        l1.add(h1);
        l1.add(h2);
        l1.add(h3);
        l1.add(h4);
        //l1.list();

        HeroNode q1 = new HeroNode(2, "ab", "asa");
        HeroNode q2 = new HeroNode(4, "bd", "bsb");
        HeroNode q3 = new HeroNode(6, "cf", "cac");
        HeroNode q4 = new HeroNode(8, "dfd", "dsd");
        SingleLinkedList l2 = new SingleLinkedList();
        l2.add(q1);
        l2.add(q2);
        l2.add(q3);
        l2.add(q4);

        //l2.list();

        SingleLinkedList l3 = l1.mergerLinkedList(l1, l2);
        l3.list();

    }
}
