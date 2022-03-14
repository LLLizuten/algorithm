package leetcode.排序;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-03-14 10:34
 * 给定一个数组nums和整数k
 * 找出数组排序后第k个最大整数
 */
public class FindKthLargest {
    /**
     * 调用库函数排序后返回
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


}
