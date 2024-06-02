package demo13_heapify;

import java.util.PriorityQueue;

//求数据流中的中位数
/*
 *   相当于求数据流中的第k位数字
 *   但是，这个k会随着加入的数据变
 *   如果用顶堆做，也就是说顶堆数组大小可以变化，这个好说，但是怎么去判断呢
 *
 *   奇数加
 *   假如现在有135，左边小顶1，右边大顶3，中间2自己留着
 *   if现在来小于等于三（可相等）-------应该加左顶，右顶+3
 *   else if 来（大于三）-----应该假如右顶，左顶+3
 *   中位数是左顶+右顶
 *
 *   偶数加
 *   假如现在2468，左边小顶4，右边大顶6，如果4-6，加中间，
 *   如果小于左顶，加左放4为中
 *   如果大于右顶，加右放6为中
 *   中位数就是中位数
 *
 *    前面的思路把多出来middle的存外面来保证两个堆平衡
 *   看老师的思路修正：没必要分奇数偶数，全部先存左边后存右边，要找答案如果是奇数直接使用左边堆顶就行
 */
public class Solution4_295 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(25001);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(25001, (a, b) -> b - a);
    public void MedianFinder() {}
    public void addNum(int num) {
        if (minHeap.size()==maxHeap.size()){
            //往左边加，看右边与加入数的最大的那个
            if (!minHeap.isEmpty()&&num>minHeap.peek()){
                minHeap.offer(num);
                num=minHeap.poll();
            }maxHeap.offer(num);
        }else {
            if (!maxHeap.isEmpty()&&num<maxHeap.peek()){
                maxHeap.offer(num);
                num=maxHeap.poll();
            }minHeap.offer(num);
        }
    }
    public double findMedian() {
        if (maxHeap.size()!=minHeap.size())return maxHeap.peek();
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}
