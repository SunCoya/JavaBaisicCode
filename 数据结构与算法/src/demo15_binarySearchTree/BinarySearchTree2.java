package demo15_binarySearchTree;
//泛型只能使用extends，防止其变成接口
public class BinarySearchTree2<E extends Comparable<E>,V> {
    static class BSTNode<E,V>{
        E key;
        V value;
        BSTNode<E,V> left;
        BSTNode<E,V> right;
        public BSTNode(E key) {
            this.key = key;
        }
        public BSTNode(E key, V value) {
            this.key = key;
            this.value = value;
        }
        public BSTNode(E key, V value, BSTNode<E,V> left, BSTNode<E,V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    BSTNode<E,V> root;
    public V get(E key){
        BSTNode<E,V> p = root;
        while (p!=null){
            int result = p.key.compareTo(key);
            if (result>0)p=p.left;
            else if (result<0)p=p.right;
            else return p.value;
        }
        return null;
    }
}
