package Day36;

import org.junit.Assert;
import org.junit.Test;
//Assert断言：检验方法结果
public class Demo366JUnitAssert {
    @Test
    public void method1(){
        Demo366JUnitAssert jt = new Demo366JUnitAssert();
        int res = jt.add(1, 1);
        //参数一：两个结果不一样的提示消息
        //这里的Assert也可以删除
        Assert.assertEquals("这个方法出错了",2,res);
    }
    public int add(int a,int b){
        return a*b;
    }
}
