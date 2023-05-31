package com.wwh.likou.binarytree;

/**
 * 递归方式深度遍历二叉树
 */
public class TreeTraversal {

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
//        preOrder(root);
//        inOrder(root);
        postOrder(root);
    }

    /**
     * <h3>前序遍历</h3>
     * @param node 节点
     */
    static void preOrder(TreeNode node) {
        if (null == node){
            return;
        }
        System.out.print(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * <h3>中序遍历</h3>
     * @param node 节点
     */
    static void inOrder(TreeNode node) {
        if (null == node){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    /**
     * <h3>后序遍历</h3>
     * @param node 节点
     */
    static void postOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        postOrder(node.left); // 左
        postOrder(node.right); // 右
        System.out.print(node.val + "\t"); // 值
    }
}
