package Day30_IOPractice;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
制造假数据：假做姓名然后写道文件里面
1.把网址上面爬到到一行行数据拼接成字符串的具体步骤？
2.正则表达式：需要表示字符时一定需要把字符用[]包裹吗？
3.有什么方法可以表示后面跟着逗号或者句号？
4.又有哪些方法表示只取前面的那部分？
5.如何在截取字符串中符合正则表达式的字串的时候只截取分组？
6.如何把集合中的部分数据取出删除（快速方法）？
7.把数组变成List再使用加入集合（快速方法）？
8.如何使自己创造的集合数据（如姓名）不重复？
*/
public class Demo301 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day30_IOPractice\\MyText\\name.txt";
    final static String WEB_STRING1 = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
    final static String WEB_STRING2 = "http://www.haoming8.cn/baobao/10881.html";
    final static String WEB_STRING3 = "http://www.haoming8.cn/baobao/7641.html";

    public static void main(String[] args) throws IOException {
        //获取数据网址数据,方法一：爬取数据：把网址上面爬到到一行行数据拼接成字符串
        System.out.println("1.重要步骤有：获取URL对象，连接网址");
        System.out.println("读取数据，通过连接获得输入流->转换流->字符缓冲流");

        String familyNameStr = webCrawler(WEB_STRING1);
        String boyNameStr = webCrawler(WEB_STRING2);
        String girlNameStr = webCrawler(WEB_STRING3);

        System.out.println("2.字符不一定非要用[]括起来，直接写上去即可");
        System.out.println("3.可以用（，|。）或者[，。]去代表后面跟的字符（虽然搜索范围变大很多）");
        System.out.println(" 4.？<=忽略前面的内容，？=忽略掉后面的内容，也可以分组取出用（）框起来的部分");
        System.out.println("方法中传入第三个参数代表取第几组：可以去除不需要的组");
        System.out.println("5.在matcher匹配到字符串之后，使用group方法获取特定组的数据");

        ArrayList<String> familyNameTempList = getData(familyNameStr, "(....)[，。]", 1);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "(<p>)((..、)*.{2}。)(</p>)", 2);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "(<p>)((.. )*.{2})(</p>)", 2);

        //处理数据
        ArrayList<String> familyNameList = new ArrayList<>();
        ArrayList<String> boyNameList = new ArrayList<>();
        ArrayList<String> girlNameList = new ArrayList<>();
        for (String s : familyNameTempList)
            for (int i = 0; i < s.length(); i++)
                familyNameList.add(s.charAt(i) + "");

        System.out.println("6.IDEA提示方法：使用subList方法分离数据，然后使用clear方法清除这一部分数据");
        familyNameList.subList(familyNameList.size() - 4, familyNameList.size()).clear();

        for (String[] strings : boyNameTempList.stream().map(s -> s.replace("。", ""))
                .map(s -> s.split("、")).collect(Collectors.toList()))
            boyNameList.addAll(Arrays.asList(strings));
        System.out.println("IDEA提示方法：使用Arrays工具类的asList把数组变成集合，再使用List中的addAll方法全部加入");
        for (String[] strings : girlNameTempList.stream().map(s -> s.split("\\s")).collect(Collectors.toList()))
            girlNameList.addAll(Arrays.asList(strings));

        //生成数据
        System.out.println("8.姓名不重复怎么整？？使用HashSet作为姓名容器即可");
        ArrayList<String> arrayList = getInfos(familyNameList, boyNameList, girlNameList, 20, 20);
        Collections.shuffle(arrayList);
        BufferedWriter bf = new BufferedWriter(new FileWriter(FILE_STRING));
        for (String s : arrayList) {
            bf.write(s);
            bf.newLine();
        }
        bf.close();
    }

    //方法一：爬取数据：把网址上面爬到到一行行数据拼接成字符串
    public static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        //1.获取URL对象，连接网址
        URL url = new URL(net);
        URLConnection conn = url.openConnection();
        //1.读取数据，通过连接获得输入流->转换流->字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        br.close();
        return sb.toString();
    }

    //方法二：初步处理爬取到的数据：得到大部分有用的数据
    private static ArrayList<String> getData(String str, String regex, int index) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        //5.在matcher匹配到字符串之后，使用group方法获取特定组的数据
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) arrayList.add(matcher.group(index));
        return arrayList;
    }

    //方法三：传入男生个数，女生个数，获取随机男生女生信息：随机姓名-性别-随机年龄
    public static ArrayList<String> getInfos(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList,
                                             int boyCount, int girlCount) {
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        //使用HashSet使数据不重复
        HashSet<String> boyHashSet = new HashSet<>();
        HashSet<String> girlHashSet = new HashSet<>();
        //这里原本是写了一个拼接姓名方法，简化了
        while (boyHashSet.size() < boyCount)
            boyHashSet.add(familyNameList.get(random.nextInt(familyNameList.size())) + boyNameList.get(random.nextInt(boyNameList.size())));
        while (girlHashSet.size() < girlCount)
            girlHashSet.add(familyNameList.get(random.nextInt(familyNameList.size())) + girlNameList.get(random.nextInt(girlNameList.size())));
        //能写一行就写一行了，不用再去定义SJ一个一个加,也简化了
        for (String s : boyHashSet) arrayList.add(s + "-男-" + random.nextInt(16, 28));
        for (String s : girlHashSet) arrayList.add(s + "-女-" + random.nextInt(16, 28));
        return arrayList;
    }
}
