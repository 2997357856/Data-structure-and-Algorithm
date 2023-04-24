package com.yzx.LinearTest.StackTest;

import com.yzx.linear.Stack;

/**
 * @Author YZX
 * @Create 2023-04-24 17:07
 * @Java-version jdk1.8
 */
//将逆波兰表达式的计算结果返回
public class ReversePoland {

    public static void main(String[] args) {
        //2*(8-3)+6
        String[] str = new String[]{"2","8","3","-","*","6","+"};
        int calculate = calculate(str);
        System.out.println("计算结果为:"+calculate);
    }

    /**
     * @description 将逆波兰表达式的结果返回
     * 原理：如果遇到数字就入栈，如果遇到符号就弹出栈顶两个元素并且和符号进行计算，将计算完的结果再次入栈
     * 反复直到遍历完整个表达式
     * @date 2023/4/24 17:13
     * @params [str] 要计算的逆波兰表达式
     * @returns int 返回结果
     */
    public static int calculate(String[] str){
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];//获得当前元素
            //如果是数字则入栈
            if(s.matches("[0-9]")){
                stack.push(Integer.parseInt(s));
            }else {
                //否则为符号则计算
                //先取出栈顶的两个数字
                int two = stack.pop();
                int one = stack.pop();
                //计算结果
                int cal = 0;
                //开始匹配符号
                switch (s){
                    case "+":{
                        cal = one+two;
                        break;
                    }
                    case "-":{
                        cal = one-two;
                        break;
                    }
                    case "*":{
                        cal = one*two;
                        break;
                    }
                    case "/":{
                        cal = one/two;
                        break;
                    }
                }
                //将计算结果入栈
                stack.push(cal);
            }
        }
        return stack.pop();
    }
}
