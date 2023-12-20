package leetcode.树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lzy
 * 2022/3/31 15:43
 * 105.从前序与中序遍历序列构造二叉树
 * 给出一棵二叉树前序遍历和中序遍历的序列
 * 构造一棵二叉树
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //先获取前序遍历和中序遍历中元素的长度,得到节点个数
        int preLen = preorder.length;
        int inLen = inorder.length;

        //一棵树的前序遍历和中序遍历序列必定相同,如果不相同说明参数错误
        if (preLen != inLen) {
            throw new RuntimeException("illegal input data");
        }

        //将中序遍历序列中元素与所在索引位置放入hashMap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //重载bulidTree
        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        //递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        //获取根节点
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        //获取根节点在map中对应的索引位置
        int pIndex = map.get(rootValue);

        //分别递归左右子树
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);

        return root;
    }
}
