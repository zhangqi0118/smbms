package com.smbms.mapper;


import com.smbms.pojo.Provider;
import com.smbms.service.ProviderService;
import org.testng.annotations.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProviderMapperTest {

    @Test
    public void addProvider() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        Provider provider=new Provider();
        provider.setProName("谷歌");
        if(context.getBean(ProviderService.class).addProvider(provider)>0){
            System.out.println("添加成功");
        }

    }

}