package com.azhu.springbootdatasource.service.impl;

import com.azhu.springbootdatasource.mapper.UserInfoMapper;
import com.azhu.springbootdatasource.model.po.UserInfo;
import com.azhu.springbootdatasource.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:07
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;



    @Override
    public UserInfo get(Integer i) {
        return userInfoMapper.get(i);
    }

    @Override
    public void deleteUser(Integer userId) {
        userInfoMapper.delete(userId);
    }

    @Override
    public void insertUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }


}
