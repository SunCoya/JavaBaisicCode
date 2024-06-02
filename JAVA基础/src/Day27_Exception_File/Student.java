package Day27_Exception_File;

import Day27_Exception_File.MyException.NameFormatException;
//测试使用的学生类：具有特殊的set方法，会抛出异常
public class Student {
    private String name;
    private  int age;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!(name.length()>=2&&name.length()<=3)){
            System.out.println("2.在抛出自定义异常时，可以在new异常时使用有参构造返回错误信息");
            throw new NameFormatException(name+"长度有误，长度应该为2-3");
        }
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age>40||age<18){
            throw new RuntimeException(age+"年龄有误，应该为18-40");
        }
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
