package Day31_Threads.demo312;

//创建实现类：表示多线程要执行的任务
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //使用Thread调用静态方法获取到当前线程的对象
            System.out.println(Thread.currentThread().getName() + i);
        }

    }
}
