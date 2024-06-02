package demo09_stack;

import java.util.LinkedList;
//力扣232，两个栈实现先入先出队列
//不会，第一次思考觉得不可能
//听老师的实现思路是，入队就像入栈，出队呢？把第一个栈里面的东西全部移动到第二个栈，然后pop
public class MyQueue {
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();
    public MyQueue() {}
    public void push(int x) {
        stack2.push(x);
    }
    public int pop() {
        if (stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }
    public int peek() {
        if (stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.peekFirst();
    }
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
