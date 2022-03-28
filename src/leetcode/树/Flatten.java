package leetcode.树;

/**
 * @author lzy
 * 2022/3/26 16:18
 * 114.二叉树展开为链表
 * 分解问题思路
 * 输入节点root,root为根的二叉树会被拉平为一条链表
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //分别把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        //在后序位置,获取拉平后的两节点
        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树的节点移到原来右子树的位置
        root.left = null;
        root.right = left;

        //将原来的右子树加上
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
