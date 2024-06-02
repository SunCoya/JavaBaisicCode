package Day31_Threads.demo313;

import java.util.concurrent.Callable;

//1.实现callable接口
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call(){
        return 100;
    }
}
