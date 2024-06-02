package demo18_Hash;

import org.testng.annotations.Test;

public class TestHashTable {
    @Test
    public void testHash() {
        HashTable table = new HashTable();
        table.put(1,"zhang","张三");
        table.put(17,"li","李四");
        table.put(2,"wang","王五");
        System.out.println(table.size);
        System.out.println(table.table[1].next.value);
        table.put(1,"zhang","张张");
        System.out.println(table.get(1,"zhang"));
        System.out.println("zhang".hashCode());
        System.out.println("删除");
        System.out.println(table.remove(1,"zhang"));
        System.out.println(table.table[1].value);
    }


    //hash算法，又叫散列算法
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //不同对象hash值不一样
            Object o = new Object();
            System.out.println(o.hashCode());
        }
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        //字符串的hash码：取值相同的字符串hash码相同，尽量让不同的字符串产生的哈希码不同
        int hash = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            //a*100+b*10+c
            //hash=hash*10+c;
            //质数选择31，这就是java中的实现
            //hash=hash*31+c;
            //移位运算效率更高
            hash = hash<<5-hash+c;
        }
    }

    @Test
    public void testLiKou(){
        String[] strings = new String[1];
        strings[0]="hit";
        new Solution6_819().mostCommonWord2("Bob hit a ball, the hit BALL flew far after it was hit.",strings);
    }
}
