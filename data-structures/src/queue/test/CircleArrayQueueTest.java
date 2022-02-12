package queue.test;

import org.junit.Test;
import queue.CircleArrayQueue;

import static org.junit.Assert.*;

/**
 * @author lzy
 * @create 2021-11-29 22:15
 */
public class CircleArrayQueueTest {
    @Test
    public void test(){
        CircleArrayQueue queue = new CircleArrayQueue(5);
        queue.showQueue();

        queue.addQueue(46);
        queue.addQueue(26);
        queue.addQueue(36);
        queue.addQueue(6);
        queue.showQueue();

        System.out.println(queue.getQueue());
        System.out.println(queue.size());
        queue.showQueue();

    }
}