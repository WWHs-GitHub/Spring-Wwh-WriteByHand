package com.wwh.likou.binarytree;

import java.util.Arrays;

/**
 * 根据中序与后序遍历结果构造二叉树
 */
public class E10Leetcode106 {

     /*
        inOrder = {4,2,1,6,3,7}
        postOrder = {4,2,6,7,3,1}

        根 1
           in        post
        左 4,2       4,2
        右 6,3,7     6,7,3
     */

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0 || postOrder.length == 0){
            return null;
        }

        int rootValue = postOrder[postOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        for (int i = 0; i < inOrder.length; i++) {
            if (rootValue == inOrder[i]){
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] postLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] postRight = Arrays.copyOfRange(inOrder, i, inOrder.length - 1);

                root.left = buildTree(inLeft,postLeft);
                root.right = buildTree(inRight,postRight);
                break;
            }
        }

        return root;
    }

}
