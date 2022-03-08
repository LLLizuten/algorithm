package 常见算法.排序算法;

/**
 * @author lzy
 * @create 2022-02-22 22:46
 * 选择排序
 * 首先在未排序列中找出最小元素,放入排序队列首位
 * 继续从未排序列中找出最小元素,放入排序队列末尾
 * 循环至排序完成
 */
public class SelectionSort {
    public static int[] sort(int[] arr){
        //总共要进行n-1轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            //初始时设最小元素的下标为0
            int min = i;
            //循环遍历数组,找出最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    //min可能在循环中会改变多次,当循环结束时即可找到最小元素下标
                    min = j;
                }
            }
            //如果找出的最小元素下标与初始设置不同,则交换两下标中的元素
            if (i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
