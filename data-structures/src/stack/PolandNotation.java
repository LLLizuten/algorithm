package stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lzy
 * @create 2022-02-25 18:25
 * 逆波兰计算器的实现
 * 后缀表达式
 *
 */
public class PolandNotation {
    public static void main(String[] args) {
        //定义一个逆波兰表达式
        //(3+4)*5-6     --->    3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 - ";
        //将其放入ArrayList中
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        //计算逆波兰表达式,完成计算器功能
        int res = calculate(list);
        System.out.println("结果为：" + res);


    }

    /**
     * 测试中缀表达式转后缀表达式
     */
    @Test
    public void test1(){
        //将一个中缀表达式字符串放入arraylist中
        String expression = "(3+4)*5-6";
        List<String> ls = toList(expression);
        System.out.println(ls);

    }

    /**
     * 将一个逆波兰表达式放入ArrayList中
     * 该逆波兰表达式为事先已经定义好的,且数字和运算符间以空格分开
     */
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    /**
     * 计算后缀表达式
     * 将list中的表达式放入栈中并计算
     */
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();

        for (String item : ls) {
            //匹配多位数
            if (item.matches("\\d+")){
                //入栈
                stack.push(item);
            }else { //符号
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                if ("+".equals(item)){
                    res = num1 + num2;
                }else if ("-".equals(item)){
                    res = num1 - num2;
                }else if ("*".equals(item)){
                    res = num1 * num2;
                }else if ("/".equals(item)){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("符号异常");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀表达式转后缀表达式
     * (3+4)*5-6     --->    3 4 + 5 * 6 -
     * 因为直接对str扫描不方便,因此先将字符串转为ArrayList
     */
//    public static List<String> toSuffix(List<String> ls){
//        //符号栈
//        Stack<String> stack = new Stack<>();
//        //存放中间结果
//        ArrayList<String> s2 = new ArrayList<>();
//        //遍历ls
//        for (String l : ls) {
//
//        }
//    }

    /**
     * 将中缀表达式转为对应List
     */
    public static List<String> toList(String s){
        ArrayList<String> ls = new ArrayList<>();
        //用于遍历的索引
        int i = 0;
        //用于对多位数的拼接
        String str;
        //每遍历到一个字符,就放入到c
        char c;
        do {
            //如果c是一个非数字,加入到ls
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                ls.add(""+c);
                i++;
            }else {
                //如果是一个数,需要考虑多位数
                str="";
                while (i < s.length() && (c=s.charAt(i)) >=48 && (c=s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }

}
