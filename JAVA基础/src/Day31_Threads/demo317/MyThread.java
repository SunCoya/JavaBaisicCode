package Day31_Threads.demo317;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
            //出让当前线程执行权：能够使得线程抢占更加均匀
            Thread.yield();
        }
    }
}
