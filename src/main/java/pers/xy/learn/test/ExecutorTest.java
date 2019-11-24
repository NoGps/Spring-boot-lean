package pers.xy.learn.test;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class ExecutorTest {
    @Async("asyncExecutorTest")
    public Future<String> getFuture() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("async");
        return new AsyncResult<>("what happen");
    }

    public void test(){
        try {
            System.out.println(System.currentTimeMillis());
            Future<String> result = getFuture();//内部调用，将同步执行，外部调用将使用代理对象增强；
            System.out.println("begin");
            String test = result.get();
            System.out.println(System.currentTimeMillis());
            System.out.println("end");
            System.out.println(test);
        }catch (Exception ex){
            System.out.println("error");
        }
    }
}
