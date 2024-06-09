package demo21_greedy;

/*
* 传递abc，在java中怎么传递呢
* 006100620063（16进制）
*
* 现在0a 1b 10c
* abc就变成了0110
* 反过来能变回来吗？解码不行
*
* 如果用一个满二叉树（不是完全二叉树！）去编码，字符只能在叶子节点
*       /\
*      0  1
*     /\  a
 *   0  1
 *   b  c
*
* a1  b00 c01
*
* 把出现频率最高的换成短的数字更加划算，如abccccc，把c变成0就好
* 这种最好的解法生成的树就是哈夫曼树
* */
public class Huffman {
    /*
    * 统计各个树出现次数，放入优先级队列
    * 把两个频次最低的元素出队，找个爹，爹的值是两个元素的和，爹放入队列
    * 当队列元素只有一个的时候，哈夫曼树构建完成
    * */
    public static void main(String[] args) {
        String origin = "aabbccccccc";
        HuffmanTree huffmanTree = new HuffmanTree(origin);
        System.out.println(huffmanTree.decode(huffmanTree.encode()));
    }
}
