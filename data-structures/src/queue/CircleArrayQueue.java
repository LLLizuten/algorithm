package queue;

/**
 * @author lzy
 * @create 2021-11-29 15:20
 * 循环数组队列
 */
public class CircleArrayQueue {
    private int maxSize;
    /**
     * front指向队列第一个元素所在位置，初始为0
     * rear指向队列最后一个元素的后一个位置，初始为0
     * arr用于存放数据，模拟队列
     */
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否空
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 添加数据
     * 因为是环形队列，rear后移时需要考虑取模
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("Queue is full.");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出数据，并得到值
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        //从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + i % maxSize + "] = " +arr[i % maxSize]);
        }
    }

    /**
     * 当前队列有效数据个数
     */
    public int size(){
        return (rear - front + maxSize) % maxSize;
    }
}
