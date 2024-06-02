package Day35_Reflect_DynamicAgent;
//四个构造方法：两个是私有的
//有个成员方法抛出了异常
public class Student {
    private String name;
    private int age;
    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

    private Student(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) throws Exception{
        this.name = name;
    }

    public void setAge(int age) {
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
