package com.chungfung.controller;

import com.chungfung.task.MyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/8 09:39
 * @Version 1.0
 */
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private MyTask myTask;

    @RequestMapping("test")
    @ResponseBody
    public String taskTest() throws InterruptedException {
        long l1 = System.currentTimeMillis();

        Future<String> future1 = myTask.test1();
        Future<String> future2 = myTask.test2();
        Future<String> future3 = myTask.test3();

        while(true) {
            if(future1.isDone()&&future2.isDone()&&future3.isDone()){
                break;
            }
            Thread.sleep(1000);
        }

        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        return "SUCCESS";
    }
}
