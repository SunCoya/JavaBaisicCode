package Day28_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件拷贝改进：快速拷贝大文件
public class Demo286 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\33428\\Videos\\haniwa\\いつだって戦ってる.mp4");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\33428\\Desktop\\Haniwa.mp4");
        byte[] bytes = new byte[1024 * 1024*10];
        int len;
        while ((len = fis.read(bytes)) != -1) fos.write(bytes, 0, len);
        fos.close();
        fis.close();
    }
}
