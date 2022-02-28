package linkedlist.test;

import linkedlist.Boy;

/**
 * @author lzy
 * @create 2022-02-23 21:07
 * 环形单向链表
 * 以类Boy为节点
 */
public class CircleSingleLinkedList {
    /**
     * 添加一个first节点
     */
    private Boy first = null;

    /**
     * 添加节点
     * @param nums 添加的节点个数
     */
    public void add(int nums){
        if (nums < 1){
            System.out.println("nums错误");
            return;
        }
        //辅助指针,用于辅助环形链表的构建
        Boy curBoy = null;
        for (int i = 1; i <= nums ; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                //构成环
                first.next = first;
                //让辅助指针指向first节点
                curBoy = first;

            }else {
                //当前节点与下一节点链接
                curBoy.next = boy;
                //新增节点与头节点链接,形成环
                boy.next = first;
                //辅助指针后移,移动到下一个节点
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历
     */
    public void list(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;

        while (true){
            System.out.println(curBoy.no);
            if (curBoy.next == first){
                break;
            }
            curBoy = curBoy.next;
        }
    }

    /**
     * 计算约瑟夫问题的出队序列
     * @param startNo 开始的编号
     * @param countNum 报数个数m
     * @param nums 队列长度
     */
    public void countBoy(int startNo, int countNum, int nums){
        //对数据进行校验
        if (startNo < 1 || startNo > nums || first == null){
            System.out.println("参数输入有误");
        }
        //创建辅助指针,作用是辅助节点出圈
        Boy helper = first;
        while (true){
            if (helper.next == first){
                break;
            }
            helper = helper.next;
        }
        //将first移动到指定的startNo,helper紧随其后
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //圈中只剩一个节点时(helper==first),循环结束
        while (helper != first) {

            //first根据countNum的值开始移动(报数)
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //循环结束后,first所指的节点即是要出圈的节点
            System.out.println("节点" + first.no + "出圈");
            first = first.next;
            helper.next = first;
        }
        System.out.println("最后一个节点" + first.no + "出圈");
    }
}
