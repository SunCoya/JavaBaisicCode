package Day31_Threads.demo3111;
class MyThread extends Thread {
    static int ticket = 0;
    @Override
    public void run() {
        do {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (ticketPlus());
    }
    static synchronized boolean ticketPlus() {
        if (ticket >= 100) return false;
        ticket++;
        System.out.println("窗口" + Thread.currentThread().getName() + "在卖第" + ticket + "张票！！！");
        return true;
    }
}
