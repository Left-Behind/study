package work.azhu.springbootmybatis.mapper;

import work.azhu.springbootmybatis.pojo.UserInfo;

import java.util.List;

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

    Long insertBatchUserInfoList(List<UserInfo> list);


}