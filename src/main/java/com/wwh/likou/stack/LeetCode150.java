package com.wwh.likou.stack;

import java.util.LinkedList;

/**
 * 力扣120题 逆波兰表达式求值
 */
public class LeetCode150 {

    /*
        - 遇到数字压入栈
        - 遇到运算符，就从栈弹出两个数字做运算，将结果压入栈
        - 遍历结果，栈中剩下的数字就是结果
     */
    public int evalRPN(String[] tokens){
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t){
                case "+":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default :{ // 数字
                    stack.push(Integer.parseInt(t));
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode150 leetCode150 = new LeetCode150();
        System.out.println(leetCode150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

}
