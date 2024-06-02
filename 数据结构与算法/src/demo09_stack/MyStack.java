package demo09_stack;

import java.util.ArrayDeque;
//力扣225，同上，无实际开发意义，仅仅熟悉栈与队列结构
class MyStack {
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(100);
    public MyStack() {
    }
    public void push(int x) {
        arrayDeque.offer(x);
        for (int i = 0; i < (arrayDeque.size() - 1); i++) arrayDeque.offer(arrayDeque.poll());
    }
    public int pop() {
        return arrayDeque.poll();
    }
    public int top() {
        return arrayDeque.peek();
    }
    public boolean empty() {
        return arrayDeque.isEmpty();
    }
}
