package Day27_Exception_File;

import java.io.File;

//案例：删除多级文件夹
public class Demo2711 {
    public static void main(String[] args) {
        File file = new File("JAVA基础\\src\\Day27\\MyTxt\\directory1");
        myDelete(file);
    }
    public static void myDelete(File file){
        //当前文件可以删除（只留下有内容的文件）
        if (file.delete()){return;}
        //下面的就是文件了获取文件的数组
        File[] files = file.listFiles();
        //这里的循环在后面就不需要再删除了，进入子级目录又会在开头判断能不能删除
        for (File listFile : files) myDelete(listFile);
        //删除当前文件夹
        file.delete();
    }
}
