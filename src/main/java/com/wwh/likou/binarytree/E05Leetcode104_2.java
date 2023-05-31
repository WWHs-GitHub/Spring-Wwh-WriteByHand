package com.wwh.likou.binarytree;

import java.util.LinkedList;

/**
 * 二叉树最大深度 - 使用后序遍历(非递归)求解
 */
public class E05Leetcode104_2 {

    /*
        思路：
        1. 使用非递归后序遍历, 栈的最大高度即为最大深度
     */
    public int maxDepth(TreeNode root) {
        TreeNode cur = root; // 当前节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null; // 最近一次栈弹出的节点
        int max = 0; // 栈的最大高度
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                if (max < stack.size()){
                    max = stack.size();
                }
                cur = cur.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop){
                    pop = stack.pop();
                }else {
                    cur = peek.right;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(1), 2, new TreeNode(1)), 3, new TreeNode(1));
        System.out.println(new E05Leetcode104_2().maxDepth(treeNode));
    }
}