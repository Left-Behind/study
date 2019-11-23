package com.azhu.springbootdatasourceaop.common.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author Azhu
 * @date 2019/9/3 15:18
 */
@Aspect
//@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@Component
@ConditionalOnClass({DruidDataSource.class})
public class DataSourceAopInService implements PriorityOrdered {

    @Before("!@annotation(com.azhu.springbootdatasourceaop.common.annotation.Master) "
            + " && (execution(* com.azhu.springbootdatasourceaop.service..*.find*(..)) "
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.get*(..)) "
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.query*(..)))")
    public void setReadDataSourceType() {
        //如果已经开启写事务了，那之后的所有读都从写库读
       // if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
            DataSourceContextHolder.setRead();
            System.out.println("如果已经开启写事务了，那之后的所有读都从写库读");
            System.out.println("读库"+DataSourceContextHolder.getLocal().get());
       // }

    }

    @Before("@annotation(com.azhu.springbootdatasourceaop.common.annotation.Master) "
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.insert*(..)) "
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.update*(..))"
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.add*(..))"
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.del*(..))"
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.save*(..))"
            + " || execution(* com.azhu.springbootdatasourceaop.service..*.create*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
        System.out.println("写库"+DataSourceContextHolder.getLocal().get());
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