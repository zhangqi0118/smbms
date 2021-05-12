package com.smbms.mapper;/*package com.smbms.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.pojo.Provider;
import com.smbms.service.ProviderService;
import com.smbms.service.impl.ProviderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

public class ProviderServiceImplTest {
    @Autowired
    ProviderService providerService=new ProviderServiceImpl();
    @Test
    public void getAllProviderList() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        ProviderService providerService = context.getBean(ProviderService.class);
        PageHelper.startPage(1, 5);
        List<Provider> list = providerService.getAllProviderListByPage();
        PageInfo<Provider> pageInfo = new PageInfo<>(list);
        for (Provider provider : pageInfo.getList()) {
            System.out.println(provider);
        }
    }
}*/