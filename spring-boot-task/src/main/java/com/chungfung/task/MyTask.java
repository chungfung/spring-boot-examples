package com.chungfung.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/8 09:37
 * @Version 1.0
 */
@Component
public class MyTask {

    @Async
    public Future<String> test1(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult("执行任务1完成！");
    }

    @Async
    public Future<String> test2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult("执行任务2完成！");
    }

    @Async
    public Future<String> test3() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult("执行任务3完成！");
    }
}
