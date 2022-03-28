package leetcode.树;

/**
 * @author lzy
 * 2022-03-17 15:46
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置

        traverse(root.left, level + 1);
        System.out.println("节点" + root.val + "在" + level + "层");
        traverse(root.right, level + 1);

    }
}
