package com.azhu.springbootdatasource;

import com.azhu.springbootdatasource.model.UserInfo;
import com.azhu.springbootdatasource.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDatasourceApplicationTests {

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

        userInfo.setUserName("www.azhu.work");
        userInfo.setUserId(11);
        userInfo.setPassword("sdfsdfasd");
        userInfo.setEmail("sdfdsf");
        userInfo.setAvatarUrl("12315646489");
        Integer insert=userInfoService.insertUserInfo(userInfo);
        System.out.println(userInfo.toString());
        userInfo.setAvatarUrl("QQQQQQQQ");
        Integer update=userInfoService.updataUserInfo(userInfo);
        //Thread.sleep(500);
        System.out.println(userInfoService.queryUserInfoByUserId(11).toString());

        Integer delete=userInfoService.deleteUserInfoById(11);
    }
}
