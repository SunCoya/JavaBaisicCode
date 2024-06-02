package Day14_Polymorphism_Package_Final_Permissions_CodeBlock.demo141;

public class Person {
    String name;
    int age;

    public  void show(){
        System.out.println(name + " " + age);
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
