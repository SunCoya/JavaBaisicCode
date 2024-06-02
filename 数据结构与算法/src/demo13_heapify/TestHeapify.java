package demo13_heapify;

import org.junit.jupiter.api.Test;

public class TestHeapify {

    @Test
    public void testHeapify() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MaxHeap heap = new MaxHeap(arr);
        System.out.println(heap);
        heap.heapify();
        System.out.println(heap);
        for (int i = 0; i < 10; i++) {
            System.out.print(heap.poll() + " ");
        }
        for (int i = 0; i < 10; i++) {
            heap.offer(i);
        }
        System.out.println(heap);
    }

    @Test
    public void testHeapSort() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MaxHeap heap = new MaxHeap(arr);
        System.out.println(heap);
        heap.heapify();
        System.out.println(heap);
        heap.sort();
        System.out.println(heap);
    }

    @Test
    public void testLiKou() {
        int[] arr = {0};
        Solution3_703 solution = new Solution3_703();
        solution.KthLargest(2,arr);
        solution.add(-1);
        solution.add(1);
    }
}
