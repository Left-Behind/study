package com.azhu.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class ScanExample {
    public static void main(String[] args) {        // 添加 10w 条数据
        initData();
    }

    public static void initData() {
        Jedis jedis=new Jedis("localhost",6379);
        Pipeline pipe = jedis.pipelined();
        for (int i = 1; i < 100001; i++) {
            pipe.set("user_token_" + i, "id" + i);
        }        // 执行命令
        pipe.sync();
        System.out.println("数据插入完成");
    }
}
