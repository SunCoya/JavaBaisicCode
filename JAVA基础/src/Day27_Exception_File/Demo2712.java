package Day27_Exception_File;

import java.io.File;
import java.util.HashMap;
//案例：统计文件夹中有后缀名的文文件的个数
public class Demo2712 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\33428\\Desktop");
        HashMap<String, Integer> hashMap = new HashMap<>();
        myForEach(file, hashMap);
        hashMap.forEach((s, integer) -> System.out.println(s+":"+integer+"个"));
    }
    public static void myForEach(File file, HashMap<String, Integer> hashMap) {
        if (file.isFile()) {
            String[] strings = file.getName().split("\\.");
            if (strings.length==0)return;
            String str = strings[strings.length - 1];//后缀名
            if (hashMap.containsKey(str)) hashMap.put(str, hashMap.get(str) + 1);
            else hashMap.put(str, 1);
            return;
        }
        File[] files = file.listFiles();
        if (files == null) return;
        for (File listFile : files) myForEach(listFile, hashMap);
    }
}
