package com.wwh.likou.binarysearchtree;

import org.springframework.util.StringUtils;

/**
 * Binary Search Tree 二叉搜索树
 * 泛型key
 */
@SuppressWarnings("all")
public class BSTTree2<T extends Comparable<T>,V> {

    BSTNode root; // 根节点

    static class BSTNode<T,V> {
        T key;
        V value;
        BSTNode<T,V> left;
        BSTNode<T,V> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, V value, BSTNode left, BSTNode right) {
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
    public Object get(T key) {
//        return doGet(key,root);
        BSTNode<T,V> node = root;

        while (node != null){
            if (key.compareTo(node.key) == -1){
                node = node.left;
            }else if (key.compareTo(node.key) == 1){
                node = node.right;
            }else {
                return node; // 找到了
            }
        }

        return null; // 没找到
    }

    public static void main(String[] args) {
        BSTTree2<String,Object> bstTree1= new BSTTree2();
        BSTNode<String,Object> node1 = new BSTNode("a", "刘婵");
        BSTNode<String,Object> node3 = new BSTNode("c", "小乔");
        BSTNode<String,Object> node2 = new BSTNode("b", "孙膑", node1, node3);

        BSTNode<String,Object> node4 = new BSTNode("e", "貂蝉");
        BSTNode<String,Object> node6 = new BSTNode("g", "吕布");
        BSTNode<String,Object> node5 = new BSTNode("f", "韩信", node4, node6);

        BSTNode<String,Object> node = new BSTNode("d", "李白", node2, node5);
        bstTree1.root = node;

        System.out.println(convert(bstTree1,1));
    }

    private static Object convert(BSTTree2 bstTree1, int key){
        if (!StringUtils.isEmpty(bstTree1.get(key))){
            BSTNode node = (BSTNode) bstTree1.get(key);
            return node.value;
        }

        return null;
    }
}
