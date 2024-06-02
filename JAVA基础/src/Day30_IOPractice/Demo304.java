package Day30_IOPractice;

import Day30_IOPractice.pojo.Student;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//带权重的随机点名器，具体实现步骤使怎样的呢？
public class Demo304 {
    public static void main(String[] args) {
        File file = new File(Demo303.FILE_STRING2);
        List<String> list = new ArrayList<>();
        FileUtil.readUtf8Lines(file, list);
        System.out.println("1.用学生类接收不同类型的数据");
        List<Student> students = new ArrayList<>();
        for (String[] strings : list.stream().map(s -> s.split("-")).collect(Collectors.toList()))
            students.add(new Student(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3])));
        System.out.println("2.计算权重总和");
        double weight = 0;
        for (Student student : students)
            weight += student.getWeight();
        System.out.println("3.计算每一个人的实际比重");
        double[] arr = new double[list.size()];
        for (int i = 0; i < students.size(); i++)
            arr[i] = students.get(i).getWeight() / weight;
        System.out.println("4.计算每一个人的权重范围：为了更方便的使用随机生成的数据");
        for (int i = 1; i < arr.length; i++)
            arr[i] = arr[i] + arr[i - 1];
        System.out.println("5.随机抽取，使用二分查找搜索数据");
        double num = Math.random();
        int index = -Arrays.binarySearch(arr, num) - 1;
        System.out.println("6.修改数据");
        Student student = students.get(index);
        student.setWeight(student.getWeight() / 2);
        System.out.println("7.重新写文件,这里的toString方法已经转成对应的格式");
        list = students.stream().map(Student::toString).collect(Collectors.toList());
        FileUtil.writeUtf8Lines(list,file);
    }
}
