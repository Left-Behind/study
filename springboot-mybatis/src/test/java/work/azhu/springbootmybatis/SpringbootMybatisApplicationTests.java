package work.azhu.springbootmybatis;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.azhu.springbootmybatis.mapper.UserInfoMapper;
import work.azhu.springbootmybatis.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootMybatisApplicationTests {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testForInsert(){
        List<UserInfo> list=new ArrayList<>();
        for(int i=0;i<1000;i++){
            UserInfo userInfo=new UserInfo();
            userInfo.setUserName("user_"+i);
            userInfo.setPassword("123");
            userInfo.setAvatarUrl("www.azhu.work/image/"+i);
            userInfo.setEmail(i+"qq@email.com");
            list.add(userInfo);
        }

        Long start=System.currentTimeMillis();
        for (UserInfo info : list) {
            userInfoMapper.insertUserInfo(info);
        }
        Long end=System.currentTimeMillis();
        log.info("testForInsert: "+(end-start));
    }


    @Test
    public void testMyBatisInsert(){
        List<UserInfo> list=new ArrayList<>();

        for(int i=0;i<1000;i++){
            UserInfo userInfo=new UserInfo();
            userInfo.setUserName("user_"+i);
            userInfo.setPassword("123");
            userInfo.setAvatarUrl("www.azhu.work/image/"+i);
            userInfo.setEmail(i+"qq@email.com");
            list.add(userInfo);
        }

        Long start=System.currentTimeMillis();
        userInfoMapper.insertBatchUserInfoList(list);
        Long end=System.currentTimeMillis();
        log.info("testMyBatisInsert: "+(end-start));
    }

}
