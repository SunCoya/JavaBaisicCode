package demo09_stack;

import java.util.LinkedList;

public class Solution1_20 {
    public boolean isValid(String s) {
        if (s.length()%2==1)return false;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //反向近栈，判断的时候只要看和栈里的一样不一样就可以，在最开始考虑对应关系
            if (c=='{')list.push('}');
            else if (c=='[')list.push(']');
            else if (c=='(')list.push(')');
            else {
                if (list.isEmpty()||list.peekFirst()!=c)return false;
                list.pop();
            }
        }
        return list.isEmpty();
    }
}
