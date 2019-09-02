package com.azhu.springbootdatasource.service;

import com.azhu.springbootdatasource.model.UserInfo;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:05
 * Description:
 */
public interface UserInfoService {
    UserInfo queryUserInfoByUserId(Integer userId);

    List<UserInfo> queryAllUserInfo();

    Integer updataUserInfo(UserInfo userInfo);

    Integer deleteUserInfoById(Integer id);

    Integer insertUserInfo(UserInfo userInfo);
}
