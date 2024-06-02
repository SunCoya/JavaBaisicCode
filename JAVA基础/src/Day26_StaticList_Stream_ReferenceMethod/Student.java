package Day26_StaticList_Stream_ReferenceMethod;

public class Student {
    private String name;
    private int age;

    public Student() {
    }
    //添加方法
    public Student(String s) {
        this.name = s.split(",")[0];
        this.age  = Integer.parseInt(s.split(",")[1]);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
    public String toString() {
        return name + "-" + age;
    }
}
