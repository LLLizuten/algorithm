package 常见算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-02-22 22:30
 */
public class TestOne {
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
}
