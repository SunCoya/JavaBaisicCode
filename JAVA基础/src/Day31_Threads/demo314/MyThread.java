package Day31_Threads.demo314;

class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + " ");
        }
    }
}
