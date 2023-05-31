package com.wwh.likou.binarysearchtree;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Binary Search Tree 二叉搜索树
 */
@SuppressWarnings("all")
public class BSTTree1 {

    BSTNode root; // 根节点

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * <h3>查找关键字对应的值</h3>
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get(int key) {
//        return doGet(key,root);
        BSTNode node = root;

        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node; // 找到了
            }
        }

        return null; // 没找到
    }

    /**
     * 递归写法
     */
    private Object doGet(int key, BSTNode node) {
        if (node == null) {
            return null; // 没找到
        }
        if (key < node.key) {
            return doGet(key, node.left);
        } else if (key > node.key) {
            return doGet(key, node.right);
        } else {
            return node; // 找到了
        }
    }

    /**
     * <h3>查找最小关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
    public Object min() {
        return min(root);
    }

    private Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }

        return node.value;
    }

    /**
     * <h3>查找最大关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
    public Object max() {
        return max(root);
    }

    private Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }

        return node.value;
    }

    /**
     * <h3>存储关键字和对应值</h3>
     *
     * @param key   关键字
     * @param value 值
     */
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node; // 保存node上一个节点
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                // key存在,更新
                node.value = value;
                return;
            }
        }

        // key不存在，插入
        if (parent == null) { // 树为空
            root = new BSTNode(key, value);
            return;
        }

        if (key > parent.key) {
            parent.right = new BSTNode(key, value);
        } else {
            parent.left = new BSTNode(key, value);
        }
    }

//    private BSTNode doPut(BSTNode node, int key, Object value) {
//        if (node.key > key){
//            doPut(node.left,key,value);
//        }else if (node.key < key){
//            doPut(node.right,key,value);
//        }else {
//
//        }
//    }

    /**
     * <h3>查找关键字的前任值</h3>
     *
     * @param key 关键字
     * @return 前任值
     */
    public Object predecessor(int key) {
        BSTNode node = root;
        BSTNode ancestorFromLeft = null;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                ancestorFromLeft = node;
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return null;
        }

        // 找到节点 情况1：节点有左子树，此时前任就是左子树的最大值
        if (node.left != null) {
            return max(node.left);
        }

        // 找到节点 情况2：节点没有左子树，若离它最近的、自左而来的祖先就是前任
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    /**
     * <h3>查找关键字的后任值</h3>
     *
     * @param key 关键字
     * @return 后任值
     */
    public Object successor(int key) {
        BSTNode node = root;
        BSTNode ancestorFromRight = null;
        while (node != null) {
            if (key < node.key) {
                ancestorFromRight = node;
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return null;
        }

        // 找到节点 情况1：节点有右子树，此时后任就是右子树的最小值
        if (node.right != null) {
            return min(node.right);
        }

        // 找到节点 情况2：节点没有右子树，若离它最近的、自右而来的祖先就是后任
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }


    // 删除指定节点
    public Object remove(int key) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            if (key < node.key) {
                parent = node;
                node = node.left;
            } else if (key > node.key) {
                parent = node;
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return null;
        }

        // 删除
        if (node.left == null && node.right != null) {
            // 情况1
            shift(parent, node, node.right);
        } else if (node.left != null && node.right == null) {
            // 情况2
            shift(parent, node, node.left);
        } else {
            // 情况四 (左右孩子都有)
            // 4.1 被删除节点找后继
            BSTNode s = node.right;
            BSTNode sParent = node; // 后继父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点即为 s
            if (sParent != node) { // 不相邻
                // 4.2 处理后继的后事
                shift(sParent, s, s.right); // 不可能有左孩子
                s.right = node.right;
            }

            // 4.3 后继取代被删除节点
            shift(parent, node , s);
            s.left = node.left;
        }

        // TODO
        return node.value;
    }

    /**
     * 根据关键字删除
     * @param key - 关键字
     * @return 被删除关键字对应值
     */
    public Object delete(int key){
        List<Object> result = new ArrayList<>(); // 保存被删除节点的值
        root = doDelete(root,key,result);
        return result.isEmpty() ? null : result.get(0);
    }

    // 返回值：删剩下的节点 或者 null
    private BSTNode doDelete(BSTNode node, int key, List<Object> list){
        if (node == null){
            return null;
        }
        if (node.key < key){
            node.right = doDelete(node.right , key , list);
            return node;
        }
        if (node.key > key){
            node.left = doDelete(node.left , key , list);
            return node;
        }
        list.add(node.value);
        // 情况一 - 只有右孩子
        if (node.left == null){
            return node.right;
        }
        // 情况二 - 只有左孩子
        if (node.right == null){
            return node.left;
        }
        // 情况三 - 有两个孩子
        BSTNode s = node.right;
        while (s.left != null){
            s = s.left;
        }
        s.left = node.left;
        // 处理后继节点不相邻的情况
        s.right = doDelete(node.right , s.key , new ArrayList<>());
        return s;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (parent.left == deleted) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    // 找 < key 的所有 value
    public List<Object> less(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key < key){
                    result.add(pop.value);
                }else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找 > key 的所有 value
    public List<Object> greater(int key){
        ArrayList<Object> result = new ArrayList<>();
        /**
         BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key > key){
                    result.add(pop.value);
                }
                p = pop.right;
            }
        } */

        // 反向中序遍历
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.right;
            }else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key > key){
                    result.add(pop.value);
                }else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    // 找 >= key1 且 <= key2 的所有 value
    public List<Object> between(int key1,int key2){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key >= key1 && pop.key <= key2){
                    result.add(pop.value);
                }else if (pop.key > key2){
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BSTTree1 bstTree1 = new BSTTree1();
        BSTNode node1 = new BSTNode(1, "刘婵");
        BSTNode node3 = new BSTNode(3, "小乔");
        BSTNode node2 = new BSTNode(2, "孙膑", node1, node3);

        BSTNode node4 = new BSTNode(5, "貂蝉");
        BSTNode node6 = new BSTNode(7, "吕布");
        BSTNode node5 = new BSTNode(6, "韩信", node4, node6);

        BSTNode node = new BSTNode(4, "李白", node2, node5);
        bstTree1.root = node;

        System.out.println(convert(bstTree1, 1));
        System.out.println(bstTree1.max());
        System.out.println(bstTree1.min());

        bstTree1.put(1, "香香");
        System.out.println(bstTree1.min());

        bstTree1.put(8, "许攸");
        System.out.println(bstTree1.max());

        System.out.println(bstTree1.predecessor(8));
        System.out.println(bstTree1.successor(7));
    }

    private static Object convert(BSTTree1 bstTree1, int key) {
        if (!StringUtils.isEmpty(bstTree1.get(key))) {
            BSTNode node = (BSTNode) bstTree1.get(key);
            return node.value;
        }

        return null;
    }
}
