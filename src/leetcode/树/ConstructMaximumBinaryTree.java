package leetcode.树;

/**
 * @author lzy
 * 2022/3/28 17:15
 * 654.最大二叉树
 * 给定数组nums,根节点为nums最大值,左子树为数组左边元素,右子树为数组右边元素
 * 递归进行
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    /**
     * 定义一个函数,将nums[left,right]构造成符合条件的树,返回根节点
     */
    public TreeNode build (int[] nums, int left, int right){
        if (left > right) {
            return null;
        }
        //定义一个index用于标记
        int index = -1;
        //定义一个maxValue存放数组中的最大元素
        int maxValue = Integer.MIN_VALUE;
        //寻找当前数组遍历范围中的最大元素
        for (int i = left; i <= right; i++){
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        //创建出以最大值为根节点的二叉树
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums,left, index - 1);
        root.right = build(nums, index + 1, right);

        return root;
    }
}
