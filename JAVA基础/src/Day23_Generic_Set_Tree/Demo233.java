package Day23_Generic_Set_Tree;
/*
泛型接口：
1.如何定义泛型接口？
2.接口的实现类必须要指定泛型吗？
案例：定义泛型接口与两个不同的实现类
*/
public class Demo233 {
    public static void main(String[] args) {
        System.out.println("1.在接口后限定<>即可定义泛型接口");
        System.out.println("2.实现类能够给出具体类型，或者是继续延续泛型");
        System.out.println(new MyImplement1<String>().method("aaa"));
        System.out.println(new MyImplement2<Integer>().method(666));
    }
}

//这个类的方法返回与传参只能使用String类型
class MyImplement1<String> implements Inter<String>{
    @Override
    public String method(String str){
        return str;
    }
}

//这个类的方法返回与传参能使用任意引用数据类型
class MyImplement2<E> implements Inter<E>{
    @Override
    public E method(E e) {
        return e;
    }
}

interface Inter<E>{
    E method(E e);
}
