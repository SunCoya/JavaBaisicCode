package demo22_greedy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//活动选择问题：有限空间内选择最多个数的区间
//和填满区间不一样，这个只要看结束时间
/*
贪心策略1：选择持续时间最短的活动
0 1 2 3 4 5 6 7 8 9
—————————1
        ——————2
            ————————3
策略失败，选2不如13

贪心策略2：选择冲突最少的活动，也是错误的
————————0                               3
    ——————1                             4
    ——————2                             4
    ——————3                             4
        ——————4                         4
          ——————5                       2
               ——————————6              4
                     ——————7            4
                     ——————8            4
                     ——————9            4
                         ——————10       3
 0-5-10不如0-4-6-10


方法3：选最先开始的：若是一开始就是最大最长的，就失败了

策略4：优先选择最先结束的活动
*/
public class ActivitySelection {

    static  class Activity{
        int index;
        int start;
        int end;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Activity{" +index +'}';
        }
    }

    public static void select(Activity[] activities, int length) {
        ArrayList<Activity> result = new ArrayList<>();
        //把第一个放进去，从第二个开始加
        result.add(activities[0]);
        //上次被选中
        Activity prev = activities[0];
        for (int i = 1; i < length; i++) {
            Activity curr = activities[i];
            if (curr.start>= prev.end){
                result.add(curr);
                prev=curr;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(0,1,3),
                new Activity(1,2,4),
                new Activity(2,3,5)
        };
        //按结束时间排序
        Arrays.sort(activities, Comparator.comparingInt(Activity::getEnd));
        select(activities,activities.length);
    }
}
