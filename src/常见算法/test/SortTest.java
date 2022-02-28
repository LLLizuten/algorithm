package 常见算法.test;

import org.junit.Test;
import 常见算法.BubbleSort;
import 常见算法.QuickSort;
import 常见算法.SelectionSort;

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
        int[] arr2 = {3,4,55,6,8,90};
        int[] ints = QuickSort.quickSort(arr1, 0, 4);
        System.out.println(Arrays.toString(ints));
        System.out.println("----");
        int[] ints1 = QuickSort.quickSort(arr2, 0, 5);
        System.out.println(Arrays.toString(ints1));
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
        int[] arr2 = {3,4,5,6,8,90,7};
        int[] sort = BubbleSort.sort(arr2);
        System.out.println(Arrays.toString(sort));

    }
}
