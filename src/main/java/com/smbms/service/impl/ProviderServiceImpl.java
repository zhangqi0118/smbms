package com.smbms.service.impl;

import com.smbms.mapper.ProviderMapper;
import com.smbms.pojo.Provider;
import com.smbms.pojo.User;
import com.smbms.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderMapper providerMapper;
    @Override
    public int addProvider(Provider provider) {
        return providerMapper.addProvider2(provider);
    }

    @Override
    public List<Provider> getAllProviderListByPage() {
        return providerMapper.getAllProviderListByPage();
    }

    @Override
    public List<Provider> getAllProviderListById(Integer id) {
        return providerMapper.getAllProviderListById(id);
    }

    @Override
    public int updateProvide(Provider provider) {
        return providerMapper.updateProvide(provider);
    }

    @Override
    public int delProviderById(Integer id) {
        return providerMapper.delProviderById(id);
    }

    @Override
    public boolean getProviderByProCode(String proCode) {
        return providerMapper.getProviderByProCode(proCode)!=null?true:false;
    }
}
