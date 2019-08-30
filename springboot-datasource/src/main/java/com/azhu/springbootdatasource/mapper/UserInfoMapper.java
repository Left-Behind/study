package com.azhu.springbootdatasource.mapper;

import com.azhu.springbootdatasource.model.po.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:43
 * Description:
 */
public interface UserInfoMapper {

    @Insert("insert into user_ (userName,password,avatarUrl,email) values (#{userName},#{password},#{avatarUrl},#{email})")
    void insert(UserInfo userInfo);

    @Update("update user_ set userName=#{userName},password=#{password},avatarUrl=#{avatarUrl} where userId=#{userId}")
    void update(UserInfo userInfo);

    @Delete("delete from user_ where userId= #{id}")
    void delete(Integer id);

    @Select("select userId,userName,avatarUrl,email from user_ where userId=#{id}")//这里不能获取密码字段 这里返回的应该是一个简单的UserInfo对象
    UserInfo get(Integer id);

    @Select("select * from user_")
    List<UserInfo> listAll();

    @Select("select * from user_ where userName=#{username}")
    UserInfo getByUsername(String username);//这里用户登录可以获取密码  发送邮件也应使用这里

}