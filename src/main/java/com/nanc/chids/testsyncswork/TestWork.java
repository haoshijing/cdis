package com.nanc.chids.testsyncswork;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class TestWork {

    @Async
    public void handlerWork(){
        System.out.println(Thread.currentThread().getName());
    }

    @PostConstruct
    public void test(){
        handlerWork();
    }
}
