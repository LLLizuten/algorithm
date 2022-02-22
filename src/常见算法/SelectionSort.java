package 常见算法;

/**
 * @author lzy
 * @create 2022-02-22 22:46
 * 选择排序
 * 首先在未排序列中找出最小元素,放入排序队列首位
 * 继续从未排序列中找出最小元素,放入排序队列末尾
 * 循环至排序完成
 */
public class SelectionSort {
    public int[] sort(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
    }
}
