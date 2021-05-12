package com.smbms.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<>();
    public static void oracleDataSource(){
        dataSourceKey.set("dataSource2");
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String string = dataSourceKey.get();
        return string;
    }
}
