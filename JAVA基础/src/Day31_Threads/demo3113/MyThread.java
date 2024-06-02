package Day31_Threads.demo3113;
public class MyThread extends Thread{
    static final Object objA = new Object();
    static final Object objB = new Object();
    @Override
    public void run() {
        while (true){
            if ("线程一".equals(getName())){
                synchronized (objA){
                    System.out.println("线程一拿到了A锁，准备去拿B锁");
                    synchronized (objB){
                        System.out.println("线程一拿到了B锁，现在线程一能够结束啦");
                    }
                }
            }else {
                synchronized (objB){
                    System.out.println("线程二拿到了B锁，准备去拿A锁");
                    synchronized (objA){
                        System.out.println("线程二拿到了A锁，现在线程二能够结束啦");
                    }
                }
            }
        }
    }
}
