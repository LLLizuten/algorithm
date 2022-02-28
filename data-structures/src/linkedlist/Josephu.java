package linkedlist;

import linkedlist.test.CircleSingleLinkedList;

import java.lang.reflect.Field;

/**
 * @author lzy
 * @create 2022-02-23 21:03
 * 约瑟夫问题
 * Josephu 问题为：设编号为1，2，... n 的n 个人围坐一圈，约定编号为k（1<=k<=n）的人从1 开始报数，数
 * 到m 的那个人出列，它的下一位又从1 开始报数，数到m 的那个人又出列，依次类推，直到所有人出列为止，由
 * 此产生一个出队编号的序列
 *
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circle = new CircleSingleLinkedList();
        circle.add(5);
        //circle.list();
        circle.countBoy(1,2,5);

    }


}
