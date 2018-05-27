package com.nanc.chids;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        context.start();
    }
}
