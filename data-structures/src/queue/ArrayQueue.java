package queue;

/**
 * @author lzy
 * @create 2021-11-20 22:59
 * 用数组模拟队列
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    /**
     * 创建队列的构造器
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //初始指向队列头部-->front指向队列头的前一个位置
        front = -1;
        //指向队列尾部-->rear指向队列尾的数据所在位置
        rear = -1;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据
     * 先判断是否满
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[++rear] = n;
    }

    /**
     * 取出数据,并得到它的值
     * 先判断是否为空
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    /**
     * 显示所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
