package Day36;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
使用dom4j.jar去解析xml文档
SAX解析(Simple API for XML)：逐行读取，只能查不能改，但是查询效率高
DOM解析：整体加载到内存，形成树型结构，可查可改，我们学习的也是DOM解析工具
在dom思想中：attribute是属性
*/
public class Demo363XMLoad {
    final static String FILE_STR = "JAVA基础\\src\\Day36\\MyXML\\students2.xml";
    public static void main(String[] args) throws DocumentException {
        System.out.println("1.创建SAXReader对象");
        SAXReader saxReader = new SAXReader();
        System.out.println("2.调用saxReader的read方法，传入需要读取的文件，获取dom对象");
        Document document = saxReader.read(new File(FILE_STR));
        System.out.println(document);
        System.out.println("3.通过dom获取根标签对象");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        System.out.println("4.通过根标签获取子标签，传入参数代表限制标签名");
        List<Element> elements = rootElement.elements();
        for (Element element : elements)System.out.println(element.getName());
        System.out.println("5.通过标签获取属性，内容，把数据放到集合中");
        ArrayList<Student> arrayList = new ArrayList<>();
        for (Element element : elements) {
            //获取标签属性
            Attribute attribute = element.attribute("id");
            String id = attribute.getText();
            //获取标签
            String name = element.element("name").getText();
            String age = element.element("age").getText();
            arrayList.add(new Student(Integer.parseInt(id),name,Integer.parseInt(age)));
        }
        System.out.println(arrayList);
    }
}
