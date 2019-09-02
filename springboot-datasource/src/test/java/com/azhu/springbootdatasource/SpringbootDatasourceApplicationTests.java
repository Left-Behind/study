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
    public void queryAllUserInfoList(){
        List<UserInfo> list=userInfoService.queryAllUserInfo();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
        }
    }
}
