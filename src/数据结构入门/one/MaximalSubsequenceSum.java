package 数据结构入门.one;


import org.junit.Test;


/**
 * @author lzy
 * @create 2021-11-17 16:03
 * 53.最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素）
 * 返回其最大和。
 *
 * 示例：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaximalSubsequenceSum {
    /**
     * 贪心法
     * 当前指针所指元素之前的和小于0,则丢弃当前元素之前的数列
     *
     * 当前和 currentSum
     * 最大和 maxSum
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        //当前和(也是之前和)
        int currentSum = 0;
        //最大和
        int maxSum = nums[0];
        for (int num : nums) {
            //当前指针所指元素之前的和小于0,则丢弃当前元素之前的数列
            if (currentSum < 0){
                currentSum = num;
            }else {
                currentSum += num;
            }
            if (currentSum >= maxSum){
                maxSum = currentSum;
            }

        }
        return maxSum;
    }

    /**
     * 动态规划
     */
    public int maxSubArray3(int[] nums){
        return 0;
    }

    @Test
    public void test(){
        int[] ints = {-2,1,-3,4,-1,2,1,-5, 4};
        int[] ints2 = {-1,0,-2};
        int[] ints3 = {-1,-2,-3};
        int[] ints4 = {5,4,-1,7,8};
        int[] ints5 = {-2,1};
        System.out.println(maxSubArray1(ints));
        System.out.println(maxSubArray1(ints2));
        System.out.println(maxSubArray1(ints3));
        System.out.println(maxSubArray1(ints4));
        System.out.println(maxSubArray1(ints5));
    }

    /**
     暴力法
     力扣超时了
     */
    public int maxSubArray2(int[] nums){
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            result = Math.max(sum, result);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(sum, result);
            }
        }
        return result;
    }
}
