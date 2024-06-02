package Day31_Threads.demo319;
class MyThread extends Thread {
    static int ticket = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket >= 100) {
                break;
            }
            ticket++;
            System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
        }
    }
}
