package com.azhu.springbootdatasourceaop;

import com.azhu.springbootdatasourceaop.model.UserInfo;
import com.azhu.springbootdatasourceaop.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDatasourceAopApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() {
    }
    @Test
    public void queryAllUserInfoList() throws InterruptedException {
        List<UserInfo> list=userInfoService.queryAllUserInfo();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
        }
        UserInfo userInfo=userInfoService.queryUserInfoByUserId(1);
        UserInfo userInfo1=userInfoService.queryUserInfoByUserId(2);
        userInfo.setUserName("测试1");
        userInfo.setUserId(8);
        userInfo.setPassword("测试1");
        userInfo.setEmail("测试1");
        userInfo.setAvatarUrl("测试1");
        Integer insert=userInfoService.insertUserInfo(userInfo);
        userInfo1=userInfoService.queryUserInfoByUserId(3);
        Integer update=userInfoService.updateUserInfo(userInfo);
        //Thread.sleep(500);
        userInfo1=userInfoService.queryUserInfoByUserId(4);

    }
    @Test
    public void DEL(){
        userInfoService.deleteUserInfoById(6);
    }


    @Test
    public void TestByMaster(){
        System.out.println(userInfoService.queryUserInfoByMaster(1));
        System.out.println(userInfoService.queryUserInfoByMaster(2));
        System.out.println(userInfoService.queryUserInfoByMaster(3));
        System.out.println(userInfoService.queryUserInfoByMaster(4));
    }
}
