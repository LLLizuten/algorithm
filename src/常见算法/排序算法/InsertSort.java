package 常见算法.排序算法;

/**
 * @author lzy
 * @create 2022-02-28 22:28
 * 插入排序
 * 将数组分为已排序和未排序两个队列
 * 排序时将未排序队列中的元素逐步插入已排序队列
 * 第一次排序时，将数组第一个元素放入已排序队列；选择未排序队列中的第一个元素，与已排序队列的元素进行比较并放入对应位置
 * O(n^2)
 */
public class InsertSort {
    public static int[] insertSort(int[] arr){
        //默认数组中的第1个元素在已排序队列，所以i从1开始循环
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            //从插入元素的上一个元素开始比较
            int index = i - 1;
            //插入元素与前面的元素逐一比较,看是否存在插入元素<前面元素的情况,如果存在,则让前面的元素后移
            while (index >= 0 && insertValue < arr[index]){
                arr[index + 1] = arr[index];
                //index指针后移，以便在已排序队列有多个元素的情况下继续与前面的元素进行比较
                index--;
            }
            // 如果进入上面while循环，已发生index--,插入元素需要通过index+1的方式来取代之前元素所在位置;
            // 没进入while循环:说明插入元素>前一个元素,插入已排序队尾
            arr[index + 1] = insertValue;

        }
        return arr;
    }
}
