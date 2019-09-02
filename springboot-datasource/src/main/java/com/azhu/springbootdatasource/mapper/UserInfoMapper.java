package com.azhu.springbootdatasource.mapper;

import com.azhu.springbootdatasource.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:43
 * Description:
 */
public interface UserInfoMapper {

    @Insert("insert into user_ (userName,password,avatarUrl,email) values (#{userName},#{password},#{avatarUrl},#{email})")
    Integer insertUserInfo(UserInfo userInfo);

    @Update("update user_ set userName=#{userName},password=#{password},avatarUrl=#{avatarUrl} where userId=#{userId}")
    Integer updateUserInfo(UserInfo userInfo);

    @Delete("delete from user_ where userId= #{id}")
    Integer deleteUserInfoById(Integer id);

    @Select("select userId,userName,avatarUrl,email from user_ where userId=#{id}")//这里不能获取密码字段 这里返回的应该是一个简单的UserInfo对象
    UserInfo queryUserInfoByUserId(Integer id);

    @Select("select * from user")
    List<UserInfo> queryAllUserInfoList();


}