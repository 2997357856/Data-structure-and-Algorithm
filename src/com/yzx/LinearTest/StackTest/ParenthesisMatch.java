package com.yzx.LinearTest.StackTest;

import com.yzx.linear.Stack;

/**
 * @Author YZX
 * @Create 2023-04-24 16:37
 * @Java-version jdk1.8
 */
//利用栈实现括号匹配问题
public class ParenthesisMatch {
    public static void main(String[] args) {
        String str1 = "((上海)成都)武汉)";
        String str2 = "(上海))武汉(";
        String str3 = "((上海()))";
        String str4 = ")(";
        System.out.println(str1+",是否匹配成功:"+isMatch(str1));
        System.out.println(str2+",是否匹配成功:"+isMatch(str2));
        System.out.println(str3+",是否匹配成功:"+isMatch(str3));
        System.out.println(str4+",是否匹配成功:"+isMatch(str4));
    }

    /**
     * @description 判断参数中的括号是否完全匹配
     * 原理:当遇到(就压栈，当碰到)就弹出栈顶元素，如果弹出为空或最后栈不为空，即表示不匹配
     * @date 2023/4/24 16:44
     * @params [str]输入的字符串
     * @returns boolean 返回匹配结果
     */
    public static boolean isMatch(String str){
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            //1. 获取当前的字符
            char c = str.charAt(i);
            //2. 如果为(则入栈
            if (c == '('){
                stack.push(c);
            }
            //3. 如果为)则弹出
            if (c == ')'){
                Object o = stack.pop();
                //表示栈已经为空了，则匹配失败
                if (o==null){
                    return false;
                }
            }
        }
        //4. 判断栈是否空
        return stack.isEmpty();
    }
}
