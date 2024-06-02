package Day32_ThreadsPractice_ThreadPool.demo321;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/*
案例：五个人抢红包
需要注意的点：
1.如何保证只留下两位小数，并且计算精确呢？
使用大浮点数类,使用setScale方法保留小数
2.如何保证随机的数字最小是一分钱呢？
设置最小中奖金额，如果随机到的数字小于这个数的话，就让这个数变成这个最小金额
同时也需要保证最大的金额不会大到把剩下人的一分钱（最小金额）也给吞掉了
3.如果说是最后一个抽到红包的，还应该去随机数字吗
直接把剩余的钱款给最后一个即可

在这里的随机金额中先抢的概率更大-这或许也是不合理的地方
*/
public class MyThread extends Thread {
    static BigDecimal money = BigDecimal.valueOf(100);
    static int count = 3;
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);
    @Override
    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "来晚一步！");
                return;
            }
            BigDecimal price;
            if (count == 1) price = money;
            else
                price = BigDecimal.valueOf(new Random().nextDouble(MIN.doubleValue(),
                        money.subtract(BigDecimal.valueOf(count-1).multiply(MIN)).doubleValue()));
            count--;
            price = price.setScale(2, RoundingMode.HALF_UP);
            money = money.subtract(price);
            System.out.println(Thread.currentThread().getName() + "抢到了" + price + "元");
        }
    }
}
