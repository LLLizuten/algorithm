package leetcode.双指针;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-03-06 15:26
 * 力扣167.两数之和
 * 在有序数组中找出两个数，使它们的和为 target
 * 返回的下标从1开始
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = new TwoSum().twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i + 1, j + 1};
            }
            if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return new int[0];
    }
}
