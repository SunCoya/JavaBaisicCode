package Day32_ThreadsPractice_ThreadPool.demo322;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringJoiner;

public class MyThread extends Thread {
    static ArrayList<Integer> arrayList;
    static {
        arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
    }
    @Override
    public void run() {
        ArrayList<Integer> myArraylist = new ArrayList<>();
        while (true) {
            synchronized (MyThread.class) {
                if (arrayList.size() == 0) break;
                int index = new Random().nextInt(arrayList.size());
                Integer i = arrayList.get(index);
                arrayList.remove(index);
                myArraylist.add(i);
            }
        }
        synchronized (Thread.class) {
            if (myArraylist.size() == 0) {
                System.out.println("在此抽奖过程中，"+getName() + "没有产生任何奖项");
                return;
            }
            System.out.println("在此抽奖过程中，" + getName() + "共产生了" + myArraylist.size() + "个奖项" + "分别为");
            StringJoiner sj = new StringJoiner(",");
            Integer count = 0;
            Integer max = myArraylist.get(0);
            for (Integer integer : myArraylist) {
                sj.add(integer + "");
                count += integer;
                if (integer > max) max = integer;
            }
            System.out.println(sj + "，" + "最高奖项为" + max + "元，" + "总计额为" + count + "元");
        }
    }
}
