package com.bitchpeng.sharding.circularreference;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class TestCircle2 implements ApplicationContextAware {

    @Autowired
    private TestCircle testCircle;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public void getBean() {
        applicationContext.getBean("TestCircle2");
    }


}
