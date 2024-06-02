package Day28_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/*
案例：文件加密与解密
a^b^b之后依然是a：如100^10
1100100    a
0001010    b
—————————
1101110    密文
0001010    b
—————————
1100100    a

这里我们只看一位：
1^0^0:在这里1一直不变
1^1^1:在这里1取反变0再取反变1
0也是这样的结果。
奇妙比喻：1碰到0：不变即可，1碰到1：总得有一方变0

结论：计算机中的数据经过两次相同的异或运算之后，数据不变
*/
public class Demo2812 {
    final static String FILE_STRING = "Java基础\\src\\Day28\\MyPic\\";
    public static void main(String[] args) throws IOException {
        encryptAndDecrypt("a.jpg", "b.jpg");
        encryptAndDecrypt("b.jpg", "c.jpg");
    }

    public static void encryptAndDecrypt(String str1, String str2) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_STRING + str1);
        FileOutputStream fos = new FileOutputStream(FILE_STRING + str2);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            for (int i = 0; i < bytes.length; i++) bytes[i] ^= 66;
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }
}
