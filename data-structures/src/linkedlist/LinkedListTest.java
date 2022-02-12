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

        list.list();
        list.reverseList();
        System.out.println("reverse");
        list.list();
    }

    @Test
    public void test2(){
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");
        LinkedList<HeroNode> list = new LinkedList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);

        System.out.println(list);


    }
}
