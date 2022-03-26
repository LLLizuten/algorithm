package leetcode.树;

/**
 * @author lzy
 * 2022/3/25 17:28
 * 226.翻转二叉树
 * 遍历思路：遍历每个节点,让每个节点左右子树互换
 */
public class InvertTree {
    /**
     * 思路1:遍历的思路
     */
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){
        if (root == null) {
            return;
        }
        //前序位置交换左右节点(后序位置也可以)
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }


    /**
     * 思路2:分解问题思路
     * 给invertTree2方法一个定义:翻转以root为根的二叉树,并返回翻转后的根节点
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //先把左子树翻转，再把右子树翻转
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        //最后把该节点下的左右子树翻转，即完成了该节点下子树的翻转
        TreeNode temp = root.left;
        root.left = right;
        root.right = temp;
        return root;
    }
}
