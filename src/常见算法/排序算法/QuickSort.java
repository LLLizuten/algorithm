package 常见算法.排序算法;

/**
 * @author lzy
 * @create 2022-02-22 22:24
 */
public class QuickSort {
    public static int[] quickSort(int[] arr, int left, int right){
        //递归终止条件:当只有一个元素时停止划分(此时left==right)
        if (left < right){
            int partitionIndex = partition2(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot] ){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static int partition2(int[] arr, int left, int right){
        //选最后一个元素作为pivot元素
        int pivot = arr[right];
        //定义两个指针:i和j
        int i = left;
        //j进行移动,将比pivot小的元素放到前面去
        for (int j = left; j < right; j++) {
            //j找到比pivot小的元素后,与i指向的元素交换位置(除了循环刚开始的时候无法确定外,i所指的元素都会比pivot大)
            if (arr[j] < pivot){
                swap(arr, j, i);
                //i++保证在循环结束后i指向的元素一定比pivot大
                i++;
            }
        }
        swap(arr, i, right);
        //循环结束后,当前i所指的元素在当前序列有序,作为下一次快排的分界线返回
        return i;
    }
    public static int partition3(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot){
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

}
