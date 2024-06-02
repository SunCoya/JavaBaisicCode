package demo09_stack;

import java.util.LinkedList;

//逆波兰表达式（后缀表达式）求值，java中是把中缀改成后缀表达式
public class Solution2_120 {
    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+")) list.push(list.pop() + list.pop());
            else if (token.equals("*")) list.push(list.pop() * list.pop());
            else if (token.equals("-")) {
                int a = list.pop();
                list.push(list.pop() - a);
            } else if (token.equals("/")) {
                int a = list.pop();
                list.push(list.pop() / a);
            } else list.push(Integer.parseInt(token));
        }
        return list.peekFirst();
    }

    /*
       中缀转换成后缀
       把符号放到栈中
       a+b    放a，碰到加号，加号入栈，碰到字母放字母b，没有了就放栈里面的+
       a+b-c  ab，碰到减号，与+同级，就应该先弹出+，再把减号放进去
       a+b*c-d   ab，碰到乘号，比+优先级高，入栈乘号
       后面碰到-，先出栈顶*，优先级高，弹出*，再看栈顶+，弹出+，再入栈-，abc*+d-

       (a+b)*c 碰到括号，入栈右括号，碰到右括号就出栈所有符号，ab+c*
    */
    /*
     * 数字拼串
     * 运算符，判断优先级高低
     * 结束后还需要出栈
     *
     * 对于（），左括号应该设置为最低优先级
     * （原来的做法我default帮我变为0了，还是设置一下），让括号右边的入栈，遇到右括号处理到左括号
     * */
    public static String infixToSuffix(String exp) {
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            //再次遇到）时候，需要处理栈，直到栈出（为止
            if (c == '(') {
                list.push('(');
                continue;
            }
            if (c == ')') {
                while (list.peekFirst() != '(') sb.append(list.pop());
                list.pop();
                continue;
            }
            if (!(c == '+' || c == '-' || c == '*' || c == '/')) {
                sb.append(c);
                continue;
            }
            if (list.isEmpty() || priority(list.peekFirst()) < priority(c)) {
                list.push(c);
                continue;
            }
            //处理前面的
            while (!list.isEmpty() && priority(list.peekFirst()) >= priority(c)) sb.append(list.pop());
            list.push(c);
        }
        while (!list.isEmpty()) sb.append(list.pop());
        return sb.toString();
    }

    public static int priority(char c) {
        //直接返回
        return switch (c) {
            //还能合并呢
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '(' -> 0;
            default -> -1;
        };
    }
}
