package top100;

import java.util.HashMap;
import java.util.jar.JarEntry;

/**
 * @author lzy
 * @create 2021-11-17 14:10
 * 01两数之和
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target
 * 的那两个整数，并返回它们的 数组 下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoNumSum {
    /**
     * 用HashMap标记，key存放值，value存放对应索引位置
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>(20);
        for (int i = 0; i < nums.length; i++) {
            //如果当前遍历到的元素存在于map中,取出对应下标返回
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            //否则将当前遍历元素放入map中
            map.put(nums[i], i);
        }
        return new int[0];
    }
    /**
     * 暴力算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
