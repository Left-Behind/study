package com.azhu.springbootdatasource.common.datasource;

/**
 * @author wangchao
 * @des
 * @date 2018-3-7 下午6:07:13
 */
public class DataSourceContextHolder {
    
    //线程本地环境  
    private static final ThreadLocal<String> local = new ThreadLocal<String>();  
  
    public static ThreadLocal<String> getLocal() {  
        return local;  
    }  
  
    /** 
     * 读库 
     */  
    public static void setRead() {  
        local.set(DataSourceType.read.getType());  
    }  
  
    /** 
     * 写库 
     */  
    public static void setWrite() {  
        local.set(DataSourceType.write.getType());  
    }  
  
    public static String getReadOrWrite() {  
        return local.get();  
    }  
      
    public static void clear(){  
        local.remove();  
    }  
}

