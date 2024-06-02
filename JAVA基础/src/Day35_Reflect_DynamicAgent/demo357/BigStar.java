package Day35_Reflect_DynamicAgent.demo357;

public class BigStar implements Star {
    private String name;
    public BigStar() {}
    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name){
        System.out.println(this.name+"正在唱:"+name);
        return "谢谢";
    }
    @Override
    public void dance(){
        System.out.println("跳舞");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "BigStar{" +
                "name='" + name + '\'' +
                '}';
    }
}
