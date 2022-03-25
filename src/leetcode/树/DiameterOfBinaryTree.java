package leetcode.树;

/**
 * @author lzy
 * @create 2022-03-23 23:11
 * 543.二叉树的直径
 * 给定一棵二叉树,计算直径长度
 * 直径:树中任意两个节点间路径长度的最大值,该路径可能穿过根节点也可能不穿过根节点
 * 思路:每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
 * 遍历每个节点,算出每个节点的直径,然后取最大值
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {

    }

    void traverse(TreeNode root){
        if (root == null) {
            return;
        }

    }

    int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int depth = Math.max(leftMax, rightMax) + 1;
        return depth;
    }
}
