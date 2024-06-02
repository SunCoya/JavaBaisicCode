package demo19_sort;

import java.util.ArrayList;

//基数排：按位排序：先排个位，后排10位，不断增
//可以用于长字符
public class Demo12_RadixSort {
    public void sort(String[] arr, int length) {
        //在这里也可以变成128就能处理更多字符的排序
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
        //三位
        for (int i = length - 1; i >= 0; i--) {
            for (String string : arr) buckets[string.charAt(i) - '0'].add(string);
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String string : bucket) arr[k++] = string;
                //记得清理桶
                bucket.clear();
            }
        }
    }
}
