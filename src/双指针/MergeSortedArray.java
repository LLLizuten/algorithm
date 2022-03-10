package 双指针;

/**
 * @author lzy
 * @create 2022-03-08 15:32
 * 88.合并两个有序数组
 * 给定两个升序数组nums1和nums2,两整数m和n分别表示两数组中元素个数
 * 将nums2合并到nums1中,并按升序排序
 * 注意给定的数组是升序的,可以从后往前遍历
 *
 * 思路来自题解中的画解算法
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后往前遍历,比较两数组的末尾元素
        int i = m - 1;
        int j = n - 1;
        //m+n为nums1实际长度,-1为末尾位置索引
        int len = m + n - 1;
        //从后往前遍历,i < 0 || j < 0 时结束
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[len--] = nums1[i--];
            }else {
                nums1[len--] = nums2[j--];
            }
        }
        //无论最后如何摆放,只需将nums2中剩余元素拷贝进nums1即可
        for (int k = 0; k < j + 1; k++) {
            nums1[k] = nums2[k];
        }

    }
}
