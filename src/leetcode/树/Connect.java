package leetcode.树;

/**
 * @author lzy
 * 2022/3/26 14:48
 * 116.填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树,填充它的next指针,让这个指针指向下一个右侧节点
 */
public class Connect {
    /**
     * 迭代解法
     * 串联i层时，首先要完成i-1层的串联
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        //用一个指针标记当前节点
        Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点或所有叶子节点都串联完后循环退出
        while (pre.left != null) {
            Node temp = pre;
            //temp不为空，则把temp的左右节点串联起来
            while (temp != null) {
                //最外层已判断pre.left不为空
                temp.left.next = temp.right;
                //为串联隔壁层做准备,如果temp.next不为空说明可以串联
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                //temp向左移动,去串联另一边
                temp = temp.next;
            }
            //当此循环结束后,进入下一层
            pre = pre.left;
        }
        return root;
    }
    public Node connect3(Node root){
        if (root == null) {
            return root;
        }
        Node pre = root;
        while (pre.left != null) {
            Node temp = pre;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;}
            pre = pre.left;
        }
        return root;
    }

    /**
     * 递归思路
     */
    public Node connect2(Node root){
        traverse(root.left,root.right);
        return root;
    }

    /**
     * 将二叉树抽象成三叉树
     */
    public void traverse(Node node1, Node node2){
        if (node1 == null || node2 == null) {
            return;
        }
        //前序位置:将传入的两个节点串联起来
        //每个「三叉树节点」需要做的事就是把自己内部的两个二叉树节点穿起来
        node1.next = node2;
        //三叉树的遍历
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);

    }
}
