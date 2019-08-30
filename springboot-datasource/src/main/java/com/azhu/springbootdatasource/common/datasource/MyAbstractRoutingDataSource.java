package com.azhu.springbootdatasource.common.datasource;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author wangchao
 * @des
 * @date 2018-3-7 下午5:43:30
 */
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {

    private final int dataSourceNumber;  
    private AtomicInteger count = new AtomicInteger(0);  
  
    public MyAbstractRoutingDataSource(int dataSourceNumber) {  
        this.dataSourceNumber = dataSourceNumber;  
    }  
  
    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getReadOrWrite();
        if (DataSourceType.read.getType().equals(typeKey) && dataSourceNumber > 0) {
            // 读 简单负载均衡
            int number = count.getAndAdd(1);
            return number % dataSourceNumber;
        }
        return DataSourceType.write.getType();
    }
}
