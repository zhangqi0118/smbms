package com.smbms.service;

import com.smbms.pojo.Provider;
import com.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderService {
    int addProvider(Provider provider);
    List<Provider>getAllProviderListByPage();
    List<Provider>getAllProviderListById(@Param("id") Integer id);
    int updateProvide(Provider provider);
    int delProviderById(@Param("id") Integer id);
    boolean getProviderByProCode(@Param("proCode") String proCode);
}
