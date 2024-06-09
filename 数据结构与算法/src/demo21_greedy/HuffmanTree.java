package demo21_greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//为什么哈夫曼树会这么好呢？这是一个值得思考的问题
public class HuffmanTree {
    static class Node{
        Character ch;
        int freq;//频次
        Node left;
        Node right;
        String code;//编码
        public Node(Character ch) {
            this.ch = ch;
        }
        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int getFreq() {
            return freq;
        }
        boolean ifLeaf(){
            return left==null;
        }

        @Override
        public String toString() {
            return ch + " " + freq+ " "+code;
        }
    }
    //占用比特位
    int sum;
    String str;
    //存放字符的哈希表，
    Map<Character,Node> map=new HashMap<>();
    //树的根节点
    Node root;
    public HuffmanTree(String str) {
        this.str = str;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            //map.computeIfAbsent(c, Node::new).freq++;
            if (!map.containsKey(c))map.put(c,new Node(c));
            map.get(c).freq++;
        }
        //构造树
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getFreq));
        queue.addAll(map.values());
        //哈夫曼树每次选择最小的两个，不一定有构造之后的某个父节点
        while (queue.size()>1){
            Node p1 = queue.poll();
            Node p2 = queue.poll();
            int freq = p1.freq+p2.freq;
            queue.offer(new Node(freq,p1,p2));
        }
        root =  queue.poll();
        //进行编码
        sum= dfs(root, new StringBuilder());
    }

    public String encode(){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(map.get(c).code);
        }
        return sb.toString();
    }
    public String decode(String code){
        char[] chars = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length;) {
            Node node  = root;
            while (!node.ifLeaf()){
                if(chars[i]=='1')node=node.right;
                else node=node.left;
                i++;
            }
            sb.append(node.ch);
        }
        return sb.toString();
    }
    private int dfs(Node node, StringBuilder sb) {
        //返回int，叶子节点的值
        int sum = 0;
        if (node.ifLeaf()){
            node.code= sb.toString();
            sum=node.freq*sb.length();
        }else sum=dfs(node.left,sb.append("0"))+dfs(node.right, sb.append("1"));
        //每一步都要减，注意开始的情况
        if (!sb.isEmpty()) sb.deleteCharAt(sb.length()-1);
        return sum;
    }
}
