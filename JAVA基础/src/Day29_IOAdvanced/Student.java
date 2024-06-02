package Day29_IOAdvanced;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable{
    //序列版本号
    @Serial
    private static final long serialVersionUID = -6236032588385694199L;
    private String name;
    private int age;
    //不想序列化到本地的使用transient修饰符（瞬态）
    private transient String address;
    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
