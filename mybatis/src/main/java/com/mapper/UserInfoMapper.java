package com.mapper;


import com.pojo.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:43
 * Description:
 */
public interface UserInfoMapper {


    Integer insertUserInfo(UserInfo userInfo);

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUserInfoById(Integer id);

    UserInfo queryUserInfoByUserId(Integer id);

    List<UserInfo> queryAllUserInfoList();

    Integer insertBatchUserInfoList(List<UserInfo> list);

    Map queryUserMap(Integer userId);
}