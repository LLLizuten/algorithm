package leetcode.树.test;

import org.junit.Test;


import leetcode.树.TreeNode;


/**
 * @author lzy
 * @create 2022-03-23 22:32
 */
public class TreeTest {
    @Test
    public void test(){
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5,null,t6);
        TreeNode t4 = new TreeNode(4,t5,null);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2,t4,null);
        TreeNode t1 = new TreeNode(1,t2,t3);

        t1.traverse(t1,1);

    }
}
