package Day31_Threads.demo3110;
/*
同步代码块synchronized
把操作共享的数据给锁起来，一次只给一个线程运行
1.如何使用synchronized？
将数据共享的代码使用synchronized（锁对象）{}包裹起来
2.锁对象应该传入什么参数？
锁对象应该传入唯一的对象：在这里定义的是一个常量变量，但一般使用本类的class对象
3.在本案例中，同步代码块能够写在while循环外面吗？
不能，当有个线程抢到同步代码块之后，就会把所有代码执行完毕，其他的窗口就不用执行任务了
*/
class MyThread extends Thread {
    static int ticket = 0;
    static final Object object = new Object();
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MyThread.class) {
                if (ticket >= 100) {
                    break;
                }
                ticket++;
                System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
            }
        }
    }
}
