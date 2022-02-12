package 数据结构入门.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lzy
 * @create 2021-11-17 14:38
 * 217.存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class RepeatingElements {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }

    /**
     * 评论中看到的一个很厉害的办法
     * 利用了set自带去重的特性
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums)
            set.add(i);
        return set.size() < nums.length;
    }

}
