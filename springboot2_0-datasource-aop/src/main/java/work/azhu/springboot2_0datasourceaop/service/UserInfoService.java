package work.azhu.springboot2_0datasourceaop.service;


import work.azhu.springboot2_0datasourceaop.model.UserInfo;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:05
 * Description:
 */
public interface UserInfoService {
    UserInfo queryUserInfoByUserId(Integer userId);

    List<UserInfo> queryAllUserInfo();

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUserInfoById(Integer id);

    Integer insertUserInfo(UserInfo userInfo);
}
