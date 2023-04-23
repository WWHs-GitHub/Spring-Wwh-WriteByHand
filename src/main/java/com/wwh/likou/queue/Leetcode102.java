package com.wwh.likou.queue;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (StringUtils.isEmpty(root)){
            return list;
        }

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode treeNode = queue.poll();
//                System.out.print(treeNode + " ");
                level.add(treeNode.val);
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                    c2++;
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                    c2++;
                }
            }
//            System.out.println();
            list.add(level);
            c1 = c2;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(node);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()){
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode + " ");
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                    c2++;
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }
    }

}
