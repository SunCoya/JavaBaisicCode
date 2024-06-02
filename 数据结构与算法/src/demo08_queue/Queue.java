package demo08_queue;


//队列接口
public interface Queue<E> {
    boolean offer(E value);
    E poll();
    //获取头不移除
    E peek();
    boolean isEmpty();
    boolean isFull();
}
