package stack;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lzy
 * @create 2022-02-23 22:53
 * 用栈实现计算器
 *
 * 有bug,无法计算多位数
 */
public class Calculate {
    public static void main(String[] args) {
        Stack<String> numStack = new Stack<>();
        Stack<String> symbolStack = new Stack<>();
        String str = "1+2*6-4";
        int num1 = 0;
        int num2 = 0;
        String oper = "";
        int res = 0;
        //依次得到str中的每一个字符,并做相应处理
        for (int i = 0; i < str.length(); i++) {
            String element = str.substring(i,i+1);
            //如果是数字,需要判断是否为多位数
            if (Calculate.isNumeric(element)) {
                if (i == str.length() - 1){
                    numStack.push(element);
                }else {
                    if (Calculate.isSymbol(str.substring(i+1,i+2))) {
                        numStack.push(element);
                    }
                }
            }
            //如果是运算符
            if (Calculate.isSymbol(element)){
                //运算符栈非空
                if (!symbolStack.isEmpty()){
                    //优先级<=当前运算符,则先运算;从数栈中pop出两个数,从符栈中pop出一个运算符,进行计算
                    if (Calculate.priority(element) <= Calculate.priority(symbolStack.peek())){
                        num1 = Integer.parseInt(numStack.pop());
                        num2 = Integer.parseInt(numStack.pop());
                        oper = symbolStack.pop();
                        res = Calculate.cal(num1, num2, oper);
                        //把运算结果入数栈
                        numStack.push(String.valueOf(res));
                        //将当前操作符入符栈
                        symbolStack.push(element);
                    }else {
                        //判断当前要加入的符号的优先级,优先级>当前栈中的运算符则入栈
                        symbolStack.push(element);
                    }
                }
                //如果运算符栈为空则直接入栈
                else {
                    symbolStack.push(element);
                }
            }
        }
        //所有字符都入栈后,进行最后的计算
        while (true){
            if (symbolStack.isEmpty()){
                break;
            }
            num1 = Integer.parseInt(numStack.pop());
            num2 = Integer.parseInt(numStack.pop());
            oper = symbolStack.pop();
            res = cal(num1, num2, oper);
            numStack.push(String.valueOf(res));
        }
        System.out.println(numStack.pop());
    }

    /**
     * 用ASCII码判断字符是否为数字
     */
    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符是否为四则运算符
     */
    public static boolean isSymbol(String str){
        return Objects.equals(str, "+") || Objects.equals(str, "-") || Objects.equals(str, "*") || Objects.equals(str, "/");
    }

    /**
     * 计算方法
     * num1为先弹出的数字
     */
    public static int cal(int num1, int num2, String symbol){
        int res = 0;

        switch (symbol){
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num2 - num1;
                break;
            case "*":
                res = num2 * num1;
                break;
            case "/":
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 设置运算符的优先级
     */
    public static int priority(String oper) {
        if("*".equals(oper) || "/".equals(oper)){
            return 1;
        } else if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        } else {
            return -1;
        }
    }
}
