package stack.test;

import stack.guigu.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//后缀计算器
//中缀转后缀
public class PolandNotation {

    public static void main(String[] args) {

//        String suffixExpression = "30 4 + 5 * 6 -";
//        List<String> list = getListString(suffixExpression);
//        int res = calculate(list);
//        System.out.println(res);

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀"+infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpression(infixExpressionList);
        System.out.println("后缀"+suffixExpressionList);

    }


    //    将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s) {
        ArrayList<String> ls = new ArrayList<String>();
        int i = 0;//用于遍历的指针
        String str; //拼接多位数
        char c;//遍历到的字符

        do {
//            如果是运算符，直接加入list
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
//                如果是数字，进行拼接操作
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }


    //    中缀表达式转后缀表达式
//    将中缀的List转为后缀的List
    public static List<String> parseSuffixExpression(List<String> ls) {

//两个容器
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

//        遍历传入的后缀list
        for (String item:ls){

//            如果是一个数，直接加入s2
            if (item.matches("\\d+")){
                s2.add(item);

//                如果是“(”，直接入s1
            }else if (item.equals("(")){
                s1.push(item);

//                如果是“)”
            }else if (item.equals(")")){

//                将s1的栈顶加入s2，直到s1是“(”,将其消除
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();

//                如果是运算符，则比较优先级
            }else{

//                当s1中的运算符的优先级较大时，将s1运算符加入s2
                while (s1.size()!=0&& Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }

                s1.push(item);

            }
        }

        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;

    }


    //    将后缀表达式放入ArrayList中，方便操作
    public static List<String> getListString(String suffixExpression) {
//        将suffixExpression分割
        String[] split = suffixExpression.split(" ");

        List<String> list = new ArrayList<>();

        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls) {

        Stack<String> stack = new Stack<>();

        for (String item : ls) {

            if (item.matches("\\d+")) {  //匹配多位数

//                入栈
                stack.push(item);
            } else {

                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);

            }
        }
        return Integer.parseInt(stack.pop());
    }
}
