package 常见算法.排序算法;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-02-22 23:25
 * 比较相邻元素,前者比后者大,则交换两元素(从小到大排序)
 * 对每对相邻元素重复此步骤,在第一次循环后可得到最大元素
 *
 * 时间复杂度O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,6,7,8,9,5,4};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
    public static int[] sort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        //需要比较n-1轮
        for (int i = 0; i < arr.length - 1; i++) {
            //优化:标记本轮中是否发生了交换,若没有交换,表示待排序列已经有序,排序已完成
            boolean isSwap = false;
            //每一轮比较都可以确定一个最大数,故循环次数每次-1
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
            }
            //如果没发生交换则表示数组已经有序,可直接退出循环
            if (!isSwap){
                break;
            }
        }
        return arr;
    }
}
