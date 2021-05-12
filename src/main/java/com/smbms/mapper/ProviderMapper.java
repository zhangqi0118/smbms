package com.smbms.mapper;

import com.smbms.pojo.Provider;
import com.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    int addProvider2(Provider provider);
    List<Provider>getAllProviderListByPage();
    List<Provider>getAllProviderListById(@Param("id") Integer id);
    int updateProvide(Provider provider);
    int delProviderById(@Param("id") Integer id);
    User getProviderByProCode(@Param("proCode") String proCode);
}
