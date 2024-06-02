package Day27_Exception_File;
/*
自定义异常：让控制台报错信息更加见名知意
1.自定异常类的步骤？
2.在抛出异常时，如何随控制台输出错误自己想输出的信息？
*/
public class Demo275 {
    public static void main(String[] args) {
        System.out.println("1.定义异常类\n2.写继承关系\n3.空参构造与带参构造");
        Student student = new Student();
        student.setName("捷克罗姆");
    }
}
