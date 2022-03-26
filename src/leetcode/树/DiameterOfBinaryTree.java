package leetcode.树;

/**
 * @author lzy
 * @create 2022-03-23 23:11
 * 543.二叉树的直径
 * 给定一棵二叉树,计算直径长度
 * 直径:树中任意两个节点间路径长度的最大值,该路径可能穿过根节点也可能不穿过根节点
 * 思路:每一条二叉树的「直径」长度，就是某个节点的左右子树的最大深度之和
 *  遇到子树问题，首先想到的是给函数设置返回值，然后在后序位置做文章
 */
public class DiameterOfBinaryTree {
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    /**
     * 在计算最大深度的同时记录最大直径
     */
    int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int depth = Math.max(leftMax, rightMax) + 1;
        //计算当前节点直径
        int myDiameter = leftMax + rightMax;
        //在后序位置更新最大直径
        maxDiameter = Math.max(myDiameter, maxDiameter);
        return depth;
    }
}
