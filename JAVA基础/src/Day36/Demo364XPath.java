package Day36;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.List;
/*
Xpath技术：获取xml文档中的单个元素，依赖于dom4j
其提供了比较独特的路径思想：使用路径来定位元素节点或者是属性节点
导入jaxen.jar包（暂时未用到）
*/
public class Demo364XPath {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(Demo363XMLoad.FILE_STR));
        System.out.println("1.获取到DOM对象之后使用selectNodes方法获取节点元素");
        System.out.println("2.绝对路径:从头开始一级一级往下，可以检索多个符合这一条路径的元素，用多个/表示");
        List<Node> nodes = document.selectNodes("/students/student/name");
        for (Node node : nodes) {System.out.println(node.getText());}

        System.out.println("如果是获取单个标签，则得到第一个");
        Node node = document.selectSingleNode("students/student/name");
        System.out.println(node.getText());

        System.out.println("3.相对路径:需要找到一个当前节点,用.表示");
        Element rootElement = document.getRootElement();
        nodes = rootElement.selectNodes("./student/name");
        for (Node node1 : nodes) {System.out.println(node1.getText()); }

        System.out.println("""
                4.全文检索：直接搜索元素名，使用//，比如我的案例中可以直接使用//name
                下面的写法则是搜索所有students路径下的name，不必严格一级一级往下
                也可以写//student/name：表示搜索到的name一定要在student下一级
                也就是说有两条杠就可以随意玩，只有一条杠就需要遵守层级规则""");
        nodes = document.selectNodes("//students//name");
        for (Node node1 : nodes) {System.out.println(node1.getText()); }

        System.out.println("5.属性检索,使用//@属性名检索所有的属性");
        nodes = document.selectNodes("//@id");
        for (Node node1 : nodes) { System.out.println(node1.getText()); }

        System.out.println("6.通过特定属性检索标签：在标签后添加[@属性名]");
        nodes=document.selectNodes("//student[@id]");
        for (Node node1 : nodes) { System.out.println(node1.getName()); }

        System.out.println("7.通过固定属性检索标签，在上面的案例基础上给属性赋值即可，下面字符串中只能用单引");
        nodes = document.selectNodes("//student[@id='1']");
        for (Node node1 : nodes) { System.out.println(node1.getName()); }
    }
}
