package 常见算法.排序算法;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-03-03 17:14
 * 归并排序
 * 用到了分治和递归的思想
 * 在一个序列中找到一个中间位置,通常为(left + right / 2),以该位置为基点,将序列划分成两个序列,不断循环此步,直至序列中的每个元素自成一个序列
 * 然后开始合并,在合并过程中逐渐使序列有序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr2 = {13,4,65,6,8,90,7};
        //int[] arr2 = {13,4,65};
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }
    public static void mergeSort(int[] arr, int left, int right){
        //递归的终止条件,如果只有一个元素(left == right)则不用继续划分
        if (left < right){
            //找中间点
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

    }
    public static void merge(int[] arr, int left, int mid, int right){
        //分别比较已划分的两个序列的首位元素,按次序合并到新序列中
        int[] arr2 = new int[arr.length];
        //辅助指针,用于帮助arr2数组添加新元素
        int index = left;
        //标记左半区未排序的第一个元素和右半区未排序的第一个元素
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                arr2[index++] = arr[i++];
            }else {
                arr2[index++] = arr[j++];
            }
        }
        while (i <= mid){
            arr2[index++] = arr[i++];
        }
        while (j <= right){
            arr2[index++] = arr[j++];
        }

        //把新数组中合并后的数组复制回原来的数组
        while (left <= right){
            arr[left] = arr2[left];
            left++;
        }

    }
}
