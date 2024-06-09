package competition.W24608;

import java.util.LinkedList;

/*
你的任务是重复以下操作删除 所有 数字字符：
删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
请你返回删除所有数字字符以后剩下的字符串。

想了想用栈就可以了
* */
public class Solution1 {
    public String clearDigits(String s) {
        char[] charArray = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : charArray) {
            if (c>='0'&&c<='9'){stack.pop();}
            else stack.push(c);
        }
        int size = stack.size();
        char[] newArr = new char[size];
        for (int i = 0; i < size; i++) {
            newArr[i]= stack.pollLast();
        }
        return new String(newArr);
    }
}
