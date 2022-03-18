package leetcode.树;

/**
 * @author lzy
 * @create 2022-03-17 15:46
 * 104.二叉树的最大深度
 * 给定一个二叉树,找出最大深度
 * 说明:二叉树的深度:根节点到最远叶子节点的最长路径上的节点数
 * 叶子节点:没有子节点的节点
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        //终止条件:传进来的节点为叶子节点
        if (root == null) {
            return 0;
        }
        //返回值

        //本次递归做什么:寻找左右子树的最大深度
        int max1 = maxDepth(root.left);
        int max2 = maxDepth(root.right);

        //返回左右子树中最大深度+根节点本身的深度
        return Math.max(max1, max2) + 1;

    }
}
