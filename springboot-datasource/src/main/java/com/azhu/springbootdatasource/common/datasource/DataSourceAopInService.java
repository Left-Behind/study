package com.azhu.springbootdatasource.common.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @des
 * @date 2018-3-8 上午10:20:29
 */
@Aspect  
//@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)  
@Component
@ConditionalOnClass({DruidDataSource.class})
public class DataSourceAopInService implements PriorityOrdered {

    @Before("execution(* com.azhu.springbootdatasource.service..*.find*(..)) "
            + " or execution(* com.azhu.springbootdatasource.service..*.get*(..)) "
            + " or execution(* com.azhu.springbootdatasource.service..*.query*(..))")
    public void setReadDataSourceType() { 
        //如果已经开启写事务了，那之后的所有读都从写库读 
        if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){ 
        	DataSourceContextHolder.setRead(); 
        } 
         
    } 
 
    @Before("execution(* com.azhu.springbootdatasource.service..*.insert*(..)) "
            + " or execution(* com.azhu.springbootdatasource.service..*.update*(..))"
            + " or execution(* com.azhu.springbootdatasource.service..*.add*(..))"
            + " or execution(* com.azhu.springbootdatasource.service..*.del*(..))"
            + " or execution(* com.azhu.springbootdatasource.service..*.save*(..))"
            + " or execution(* com.azhu.springbootdatasource.service..*.create*(..))")
    public void setWriteDataSourceType() { 
        DataSourceContextHolder.setWrite(); 
    }
      
    @Override  
    public int getOrder() {  
        /** 
         * 值越小，越优先执行 
         * 要优于事务的执行 
         * 在启动类中加上了@EnableTransactionManagement(order = 10)  
         */  
        return 1;  
    }  

}

