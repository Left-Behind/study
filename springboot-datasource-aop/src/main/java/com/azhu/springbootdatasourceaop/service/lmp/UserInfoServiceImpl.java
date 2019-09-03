package com.azhu.springbootdatasourceaop.service.lmp;


import com.azhu.springbootdatasourceaop.mapper.UserInfoMapper;
import com.azhu.springbootdatasourceaop.model.UserInfo;
import com.azhu.springbootdatasourceaop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:07
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo queryUserInfoByUserId(Integer userId) {
        return userInfoMapper.queryUserInfoByUserId(userId);
    }

    @Override
    public List<UserInfo> queryAllUserInfo() {
        return userInfoMapper.queryAllUserInfoList();
    }

    @Override
    public Integer updataUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public Integer deleteUserInfoById(Integer id) {
        return userInfoMapper.deleteUserInfoById(id);
    }

    @Override
    public Integer insertUserInfo(UserInfo userInfo) {
        return  userInfoMapper.insertUserInfo(userInfo);
    }
}
