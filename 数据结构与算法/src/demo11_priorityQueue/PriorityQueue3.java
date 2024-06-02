package demo11_priorityQueue;
//堆实现优先级队列：堆本质上是一种树，通常使用完全二叉树实现，又能从左到右在数组中一个一个加
//大顶堆：父节点比子节点都大，小顶堆：父节点比子节点都小

/*
*   规律：从0存储根节点
*   节点i>0，父节点为（i-1）/2，左孩子为2*i+1，右孩子为2*i+2（需要小于size）
*   从 1开始存储节点
*   节点i>1,父节点为i/2，左子节点为2i，右子节点为2i+1
*/
public class PriorityQueue3<E extends Priority>implements Queue<E> {
    //使用大顶堆就比较好找优先级最高的
    Priority[] arr;
    int size=0;
    int capacity;
    public PriorityQueue3(int capacity) {
        this.capacity=capacity+1;
        arr = new Priority[this.capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        //不用先填值，可以在循环里面找
        int child = size++;
        //找到比他大的父亲，然后替换他
        while (child!=0){
            int parent = (child-1)/2;
            //这里要用value，不能用parent>child，因为一开始没有赋值给最后一个格子。
            if (arr[parent].priority()>=value.priority())break;
            //青出于蓝
            arr[child]=arr[parent];
            child=parent;
        }
        arr[child]=value;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        //怎么出队列呢？从栈顶开始删，然后把下面的移动上来？十分麻烦
        //惊人一交换：最下面的数和最上面的数字交换
        //直接出队列，恢复也简单，把最上面的打下去就可以咯，而且不会影响整个数组，还是无间隔排列。
        Priority value = arr[0];
        arr[0] = arr[size-1];
        arr[--size]=null;

        //往下交换，老师使用的是递归
        int parent = 0;
        while (true){
            int left = 2*parent+1;
            int right = left+1;
            //问题来了，怎么选择路呢：和大孩子交换就行
            //这里一开始是判断左孩子右孩子是否越界-判断左孩子是否越界-左右全部没有越界三种情况
            //这里可以利用是否和parent一样来改改，先判断左孩子存在且满足条件，再和右孩子（存在）且满足条件比较
            int maxChild = parent;
            if (left<size&&arr[left].priority()>arr[maxChild].priority())maxChild=left;
            if (right<size&&arr[right].priority()>arr[maxChild].priority())maxChild=right;
            if (maxChild==parent)break;
            swap(parent,maxChild);
            parent=maxChild;
        }
        return (E) value;
    }

    private void down(int i){
        int left = 2*i+1;
        int right = left+1;
        int max = i;
        //这个处理方式真厉害啊，不用去分情况讨论左右节点的存在状况了
        if (left<size&&arr[left].priority()>arr[max].priority())max=left;
        if (right<size&&arr[right].priority()>arr[max].priority())max=right;
        if(max!=i){//说明max已经找到能替代它位置的节点了
            swap(i,max);
            down(max);
        }
    }
    private void swap(int i,int j){
        Priority t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return (E) arr[0];
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public boolean isFull() {
        return size==capacity-1;
    }
}
