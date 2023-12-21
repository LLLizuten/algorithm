package 常见算法.test;

import org.junit.Test;
import 常见算法.排序算法.*;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-02-22 22:30
 */
public class SortTest {
    /**
     * 测试快排
     */
    @Test
    public void test1(){
        int[] arr1 = {1,2,44,5,66};

        int[] ints = QuickSort.quickSort(arr1, 0, 4);
        System.out.println(Arrays.toString(ints));



    }
    /**
     * 测试选择排序
     */
    @Test
    public void test2(){
        int[] arr2 = {3,4,55,6,8,90};
        int[] sort = SelectionSort.sort(arr2);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 测试冒泡排序
     */
    @Test
    public void test3(){
        int[] arr2 = {13,4,65,6,8,90,7};
        int[] sort = BubbleSort.sort(arr2);
        System.out.println(Arrays.toString(sort));

    }

    /**
     * 测试插入排序
     */
    @Test
    public void test5(){
        int[] arr2 = {13,4,2,6,8,90,7};
        int[] sort = InsertSort.insertSort(arr2);
        System.out.println(Arrays.toString(sort));

    }

    /**
     * 测试堆排序
     */
    @Test
    public void testForHeap() {
        HeapSort heapSort = new HeapSort();
        int[] arr2 = {13,4,2,6,8,90,7};
        heapSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
