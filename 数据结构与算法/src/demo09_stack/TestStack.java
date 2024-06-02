package demo09_stack;

import org.junit.jupiter.api.Test;

public class TestStack {
    @Test
    public void testLinkedStack(){
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
        System.out.println("isEmpty");
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

        System.out.println("测试push");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.forEach(System.out::println);

        System.out.println("测试pop");
        stack.pop();
        stack.forEach(System.out::println);

        System.out.println("测试isFull");
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isFull());
        stack.push(5);
        System.out.println(stack.isFull());

        System.out.println("测试满栈");
        System.out.println(stack.push(6));
        stack.forEach(System.out::println);

        System.out.println("测试peek");
        System.out.println(stack.peek());
    }
    @Test
    public void testArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        System.out.println("isEmpty");
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

        System.out.println("测试push");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.forEach(System.out::println);

        System.out.println("测试pop");
        stack.pop();
        stack.forEach(System.out::println);

        System.out.println("测试isFull");
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isFull());
        stack.push(5);
        System.out.println(stack.isFull());

        System.out.println("测试满栈");
        System.out.println(stack.push(6));
        stack.forEach(System.out::println);

        System.out.println("测试peek");
        System.out.println(stack.peek());
    }

    @Test
    public  void  testLIKOU(){
        String[] token = {"4","13","5","/","+"};
        System.out.println(Solution2_120.evalRPN(token));
        System.out.println(Solution2_120.infixToSuffix("a+b*c"));
        System.out.println(Solution2_120.infixToSuffix("a+b*c-d"));
        System.out.println(Solution2_120.infixToSuffix("(a+b)*c-d"));
        System.out.println(Solution2_120.infixToSuffix("a+b*(c-d)"));
    }
}
