package demo07_deleteLinkedListNode;
public class Solution10_88 {
    //合并有序号数组，从后往前面确定就不用别的空间了
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0)return;
        if (m==0){System.arraycopy(nums2, 0, nums1, 0, n);return;}
        int i=m-1,j=n-1;//对应，i-num2-n    j-num3-m
        for (int k = m+n-1; k >= 0; k--){
            if (i==-1){System.arraycopy(nums2,0,nums1,0,j+1);return;}
            if (j==-1)return;
            nums1[k]=nums2[j]<nums1[i]?nums1[i--]:nums2[j--];
        }
    }
}
