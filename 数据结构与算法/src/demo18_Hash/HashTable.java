package demo18_Hash;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HashTable {
    //数组不能太长，也不能保证编号不重复
    //允许有限长度数组，用链表方法存更多数据，通过数据自身区分，同时会降低一点性能
    static class Entry {
        //哈希码%数组长度就是对应位置
        //求模运算替换成位运算
        //hash%length --   hash&length-1
        int hash;
        Object key;
        Object value;
        Entry next;
        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    //长度2n次方
    Entry[] table = new Entry[16];
    int size = 0;
    final float LOAD_FACTOR = 0.75f;
    //阈值
    int threshold=(int)(LOAD_FACTOR* table.length);
    Object get(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) return null;
        Entry p = table[idx];
        while (p != null) {
            //对象比较使用equals
            if (p.key.equals(key)) return p.value;
            p = p.next;
        }
        return null;
    }

    //能增能改
    void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) table[idx] = new Entry(hash, key, value);
        else {
            //在JDK里面的Hashtable使用的是头插法，且容量为质数
            //jdk里面的hashMap链表长度过长会转换成红黑树，为了防止有人造hash数据恶意攻击
            Entry p = table[idx];
            while (true) {
                if (p.key.equals(key)) {
                    p.value = value;
                    return;
                }
                if (p.next == null) break;
                p = p.next;
            }
            p.next = new Entry(hash, key, value);
        }
        size++;
        if (size>threshold){
            //扩容
            resize();
        }
    }
    Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) return null;
        Entry p = table[idx];
        Entry parent = null;
        while (p!=null) {
            if (p.key.equals(key)) {
                if (parent==null)table[idx]=p.next;
                else parent.next=p.next;
                size--;
                return p.value;
            }
            parent=p;
            p = p.next;
        }return null;
    }
    Object get(Object key){
        return get(key.hashCode(),key);
    }
    void put(Object key,Object value){
        put(key.hashCode(),key,value);
    }
    Object remove(Object key){
        return remove(key.hashCode(),key);
    }

    private void resize() {
        Entry[] entries = new Entry[table.length<<1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            Entry a=null,b=null;
            Entry aHead = null,bHead = null;
            if (p!=null){
                //链表最多拆成两个，与旧的数组按位与&运算，为0就代表是位置不变，其余情况就得把它分到新链表里面去
                while (p!=null){
                    if ((p.hash&table.length)==0){
                        if (a!=null)a.next=p;
                        else aHead=p;
                        a=p;
                    }else {
                        if (b!=null)b.next=p;
                        else bHead=p;
                        b=p;
                    }
                    p=p.next;
                }
                //最后指向空，避免错指
                if (a!=null) {
                    a.next = null;
                    entries[i] = aHead;
                }
                if (b!=null){
                    b.next=null;
                    entries[i+table.length]=bHead;
                }
            }
        }
        table = entries;
        threshold = (int)(LOAD_FACTOR* table.length);
    }


    public void print(){
        int[] sums = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            while (p!=null){
                sums[i]++;
                p=p.next;
            }
        }
        //boxed方法转成Integer类型，collect方法里面转变成hashMap
        Map<Integer, Long> collect = Arrays.stream(sums).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < 200000; i++) {
            Object o = new Object();
            hashTable.put(o,o);
        }
        hashTable.print();
        int hash = Hashing.murmur3_32().hashString("abc", StandardCharsets.UTF_8).asInt();
        //{0=357768, 1=137135, 2=25657, 3=3394, 4=302, 5=31, 6=1}
    }

    //murmurHash是一种更加优秀的hash算法

}
