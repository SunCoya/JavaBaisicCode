package Day31_Threads.demo3114;
/*
 * 1.循环
 * 2.同步代码块
 * 3.到了末尾怎么办
 * 4.没有到末尾怎么办
 */
public class Producer extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Product.myLock){
                //到了末尾
                if (Product.count == 0)break;
                if (Product.flag==1) {
                    //有产品，等待
                    try {
                        Product.myLock. wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //没产品，生产，唤醒
                    Product.flag=1;
                    System.out.println("生产者生产完毕");
                    Product.myLock.notifyAll();
                }
            }
        }
    }
}
