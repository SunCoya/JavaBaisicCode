package Day36;

import cn.hutool.core.io.FileUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
/*
使用before与after注解备份与还原数据
*/
public class Demo367BeforeAfter {
    //在测试单元中，相对路径是在当前模块中，和类加载器一样
    final static String FILE_STR = "src\\Day36\\MyLog\\a.txt";
    final static String FILE_COPY ="src\\Day36\\MyLog\\aCopy.txt";
    @Test
    public void test(){
        boolean b = new File(FILE_STR).delete();
        Assert.assertTrue(b);
        b=new File(FILE_STR).exists();
        Assert.assertFalse(b);
        System.out.println("Test，在这个方法里面做测试");
    }
    @Before
    public void before(){
        FileUtil.copy(new File(FILE_STR),new File(FILE_COPY),false);
        System.out.println("before，使用这个方法初始化数据，比如数据的删除");

    }
    @After
    public void after(){
        FileUtil.copy(new File(FILE_COPY),new File(FILE_STR),false);
        new File(FILE_COPY).delete();
        System.out.println("after，使用这个方法还原数据，删除备份数据");
    }
}
