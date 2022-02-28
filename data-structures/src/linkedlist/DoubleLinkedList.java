package linkedlist;

/**
 * @author lzy
 * @create 2022-02-23 11:00
 * 双向链表
 * 以类HeroNode2为节点
 */
public class DoubleLinkedList {
    private static HeroNode2 head = new HeroNode2(0,"","");

    /**
     * 遍历双向链表
     */
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    /**
     * 添加节点到链表最后
     */
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    /**
     * 删除节点
     */
    public void delete(int no){
        HeroNode2 temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }
        while (temp != null){
            if (temp.id == no){
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                System.out.println("已删除");
                return;
            }
            temp = temp.next;
        }
        System.out.println("未找到要删除的节点");
    }
}
