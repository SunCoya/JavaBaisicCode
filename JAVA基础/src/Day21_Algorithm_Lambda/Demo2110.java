package Day21_Algorithm_Lambda;
import java.util.Arrays;
/*
案例：按照年龄排序GF，年龄相同则按照身高排序，身高相同则按照名字排序
1.String中compareTo方法返回的数字代表什么？
2.比较了年龄了，直接返回吗？
*/
public class Demo2110 {
    public static void main(String[] args) {
        System.out.print("1.String中compareTo方法返回的负数为小于，正数为大于：");
        System.out.println("ab".compareTo("abcd"));
        GirlFriend[] girlFriends = {
                new GirlFriend("Alice", 18, 160),
                new GirlFriend("SeaLufee", 18, 160),
                new GirlFriend("Lockxi", 18, 160)
        };
        System.out.println("2.看年龄是否相同接着在lambda表达式里面继续比较");
        Arrays.sort(girlFriends, ((o1, o2) -> {
            double i = o1.getAge() - o2.getAge();
            i = i == 0 ? o1.getHeight() - o2.getHeight() : i;
            i = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
            if (i > 0) {
                return 1;
            } else if (i < 0) {
                return -1;
            } else return 0;
        }));
        for (GirlFriend girlFriend : girlFriends) {
            System.out.println(girlFriend);
        }
    }
}

class GirlFriend {
    private String name;
    private int age;
    private double height;
    public GirlFriend() {
    }
    public GirlFriend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
