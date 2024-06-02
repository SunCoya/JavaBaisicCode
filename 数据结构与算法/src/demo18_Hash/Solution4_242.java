package demo18_Hash;

import java.util.Arrays;
//字母异位置词
public class Solution4_242 {
    public boolean isAnagram(String s, String t) {
        Arr arr1= new Arr(s.toCharArray());
        Arr arr2= new Arr(t.toCharArray());
        return arr1.equals(arr2);
    }
    static class Arr{
        int[] arr = new int[26];

        public Arr(char[] arr) {
            for (char i : arr) {
                this.arr[i-'a']++;
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Arr arr1 = (Arr) o;
            return Arrays.equals(arr, arr1.arr);
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }
}
