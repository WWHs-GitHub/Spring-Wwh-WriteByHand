package com.wwh.likou.binarytree;

/**
 * 翻转二叉树
 */
public class E07Leetcode226 {

    public TreeNode invertTree(TreeNode root){
        fn(root);
        return root;
    }

    private void fn(TreeNode root) {
        if (root == null){
            return;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        fn(root.left);
        fn(root.right);
    }
}
