package 常见算法.排序算法;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-03-01 10:31
 * 希尔排序
 *
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        int[] sort = sort(arr);
        int[] sort2 = sort2(arr);
        System.out.println(Arrays.toString(sort));
        System.out.println(Arrays.toString(sort2));
    }

    /**
     * 对有序序列在插入时采用交换法
     *
     * 以第一轮交换为思路
     *         for (int i = 5; i < arr.length; i++) {
     *             for (int j = i - 5; j >= 0 ; j-=5) {
     *                 //比较当前数与后面数的大小
     *                 if (arr[j] > arr[j + 5]){
     *                     temp = arr[j];
     *                     arr[j] = arr[j + 5];
     *                     arr[j + 5] = temp;
     *                 }
     *             }
     *         }
     */
    public static int[] sort(int[] arr){
        int temp = 0;
        //设置步长
        int gap;
        //步长与数组长度相关,一般设置步长初始长度为数组长度的一半,到1时停止
        for(gap = (arr.length / 2); gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 ; j-=gap) {
                    //比较前数与后数的大小
                     if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 移位法
     * @param arr
     * @return
     */
    public static int[] sort2(int[] arr){
        int temp;
        int gap;
        for (gap = arr.length / 2; gap > 0; gap/=2) {
            //每一趟采用插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp  = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = gap;
            }
        }
        return arr;
    }
}
