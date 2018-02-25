package com.chelp.oop.sys.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.chelp.oop.utils.PropUtil;

@Component("PropertyListener")
public class PropertyListener implements
        ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        PropUtil.loadAllProperties();
    }


}
