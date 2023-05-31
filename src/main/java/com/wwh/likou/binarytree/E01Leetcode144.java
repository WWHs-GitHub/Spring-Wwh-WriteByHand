package com.wwh.likou.binarytree;

import java.util.LinkedList;

/**
 * 非递归方式深度遍历二叉树
 */
public class E01Leetcode144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        TreeNode cur = root; // 当前节点
//       preOrder(cur);
//        inOrder(cur);
//        postOrder(cur);
        depthFirstTraversal(cur);
    }

    /**
     * <h3>前序遍历</h3>
     * @param node 节点
     */
    static void preOrder(TreeNode node) {
        TreeNode cur = node; // 当前节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                colorPrintln("来：" + cur.val,31);
                stack.push(cur); // 压入栈，为了记住回来的路
                cur = cur.left;
            }else {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
    }

    /**
     * <h3>中序遍历</h3>
     * @param node 节点
     */
    static void inOrder(TreeNode node) {
        TreeNode cur = node; // 当前节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur); // 压入栈，为了记住回来的路
                cur = cur.left;
            }else {
                TreeNode pop = stack.pop();
                colorPrintln("回：" + pop.val,32);
                cur = pop.right;
            }
        }
    }

    /**
     * <h3>后序遍历</h3>
     * @param node 节点
     */
    static void postOrder(TreeNode node) {
        TreeNode cur = node; // 当前节点
        TreeNode pop = null; // 最近一次弹出栈的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur); // 压入栈，为了记住回来的路
                cur = cur.left;
            }else {
                TreeNode peek = stack.peek(); // 栈顶元素
                if (null == peek.right || peek.right == pop){
                    pop = stack.pop();
                    colorPrintln("回：" + pop.val,32);
                }else {
                    cur = peek.right;
                }

            }
        }
    }

    /**
     * 深度遍历
     * @param node
     */
    static void depthFirstTraversal(TreeNode node){
        TreeNode cur = node; // 当前节点
        TreeNode pop = null; // 最近一次弹出栈的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                colorPrintln("前：" + cur.val,32);
                stack.push(cur); // 压入栈，为了记住回来的路
                cur = cur.left; // 遍历左子树之前
            }else {
                TreeNode peek = stack.peek(); // 栈顶元素
                if (null == peek.right){ // 右子树为空
                    colorPrintln("中：" + peek.val,33);
                    pop = stack.pop();
                    colorPrintln("后：" + pop.val,34);
                }else if (peek.right == pop){ // 遍历完右子树
                    pop = stack.pop();
                    colorPrintln("后：" + pop.val,34);
                }
                else {
                    // 遍历右子树之前
                    colorPrintln("中：" + peek.val,33);
                    cur = peek.right;
                }

            }
        }
    }

    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
