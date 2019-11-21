package work.azhu.springboot2_0datasourceaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.azhu.springboot2_0datasourceaop.model.UserInfo;
import work.azhu.springboot2_0datasourceaop.service.UserInfoService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot20DatasourceAopApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void queryAllUserInfoList() throws InterruptedException {
		List<UserInfo> list=userInfoService.queryAllUserInfo();
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.toString());
		}
		UserInfo userInfo=userInfoService.queryUserInfoByUserId(1);
		UserInfo userInfo1=userInfoService.queryUserInfoByUserId(2);
		userInfo.setUserName("www.azhu.work");
		userInfo.setUserId(8);
		userInfo.setPassword("sdfsdfasd");
		userInfo.setEmail("sdfdsf");
		userInfo.setAvatarUrl("12315646489");
		Integer insert=userInfoService.insertUserInfo(userInfo);
		userInfo1=userInfoService.queryUserInfoByUserId(3);
		Integer update=userInfoService.updateUserInfo(userInfo);
		//Thread.sleep(500);
		userInfo1=userInfoService.queryUserInfoByUserId(4);

	}
	@Test
	public void DEL(){
		userInfoService.queryUserInfoByUserId(1);
        userInfoService.queryUserInfoByUserId(2);
        userInfoService.queryUserInfoByUserId(3);
	}

}
