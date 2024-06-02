package demo12_BlockingQueue;

public interface BlockingQueue<E> {
    //会用到条件变量Condition，会多出检查异常的throws
    void  offer(E e) throws  InterruptedException;
    boolean offer(E e,long timeout) throws InterruptedException;
    E poll() throws  InterruptedException;
}
