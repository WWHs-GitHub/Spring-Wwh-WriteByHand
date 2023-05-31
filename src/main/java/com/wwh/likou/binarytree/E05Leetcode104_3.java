package com.wwh.likou.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大深度 - 使用层序遍历
 */
public class E05Leetcode104_3 {

    /**
     * 思路
     * 1.使用层序遍历，层数即最大深度
     */
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.printf(poll.val + "\t");
                if (null != poll.left){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            System.out.println();
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(1), 2, null), 4, new TreeNode(3));
        System.out.println(new E05Leetcode104_3().maxDepth(treeNode));
    }
}
