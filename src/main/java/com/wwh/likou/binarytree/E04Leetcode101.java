package com.wwh.likou.binarytree;

/**
 * 对称二叉树
 */
public class E04Leetcode101 {

    public boolean isSymmetric(TreeNode root){
        return check(root.left,root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        // left 和 right 不能同时为null
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return check(left.left,right.right) && check(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(2),2,new TreeNode(1)), 2, new TreeNode(new TreeNode(1),2,new TreeNode(1)));
        System.out.println(new E04Leetcode101().isSymmetric(treeNode));
    }
}
