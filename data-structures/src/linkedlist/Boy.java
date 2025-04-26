package linkedlist;

/**
 * @author lzy
 * @create 2022-02-23 21:05
 */
public class Boy {
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }

}
