package stack.test;

import stack.guigu.ArrayStack2;


public class Calculator {

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
//        创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;  //用于扫描
        int num1 = 0;
        int num2 = 0;   //两个操作数
        int oper = 0;   //操作符
        int res = 0;    //结果
        char ch = ' ';
        String keepNum = "";//用于拼接多位数

        while (true) {

//            依次得到expression的每个字符
            ch = expression.substring(index, index + 1).charAt(0);

//            判断ch是啥
            if (operStack.isOper(ch)) {  //如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
//                    如果符号栈不为空，则比较优先级
//                    如果当前优先级小于栈内符号优先级，则pop符号和操作数进行运算
                    if (operStack.priority(ch) <= operStack.priority(operStack.peep())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //运算结果入栈
                        numStack.push(res);
                        //再将当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //优先级大于栈中符号，直接入栈
                        operStack.push(ch);
                    }
                } else {
                    //为空直接入栈
                    operStack.push(ch);
                }

            } else { //如果是数，直接入数栈，此时考虑多位数问题

                keepNum += ch;

                //如果ch是表达式的最后一位，则直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //如果后一位是运算符,也入栈，让后清空keepNum
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }

            }
            //让index++，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }


//      表达式扫描完毕，则顺序的从两个栈中pop出相应的数和符号进行运算
        while (true) {

//            如果符号栈空，则计算到了最后的结果，就是数栈中的数字
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

//        最终的结果
        int res2 = numStack.pop();
        System.out.printf("表达式%s=%d", expression, res2);


    }
}
