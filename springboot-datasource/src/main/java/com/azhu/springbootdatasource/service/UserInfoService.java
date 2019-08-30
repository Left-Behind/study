package com.azhu.springbootdatasource.service;


import com.azhu.springbootdatasource.model.po.UserInfo;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:05
 * Description:
 */
public interface UserInfoService {

    UserInfo get(Integer userId);

    void deleteUser(Integer userId);

    void insertUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);
}
