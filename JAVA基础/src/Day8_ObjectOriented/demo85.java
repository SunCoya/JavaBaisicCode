package Day8_ObjectOriented;
import Day8_ObjectOriented.pojo.Phone5;

public class demo85 {
    public static void main(String[] args) {
        Phone5 phone=new Phone5();
        Phone5 phone1=new Phone5();
        System.out.println("输出该对象的地址"+phone);
        phone.getThis();
        System.out.println("输出该对象的地址"+phone1);
        phone1.getThis();
    }
}
