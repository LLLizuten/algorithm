package 常见算法.查找算法;

/**
 * @author lzy
 * @create 2022-03-04 16:53
 * 二分查找
 * 先保证数组有序
 * 取中间元素，将待查找元素与中间元素比较，往左或右查找
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,8};
        int index = binarySearch(arr, 0, arr.length - 1, 10);
        System.out.println(index);
    }
    public static int binarySearch(int[] arr, int left, int right, int num){
        //递归结束条件,说明没有找到
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        //num<mid,往左边找
        if (num < arr[mid]){
            return binarySearch(arr, left, mid - 1, num);
        }else if (num > arr[mid]){
            return binarySearch(arr, mid + 1, right, num);
        } else {
            return mid;
        }

    }
}
