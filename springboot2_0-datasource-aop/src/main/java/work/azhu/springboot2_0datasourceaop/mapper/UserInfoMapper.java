package work.azhu.springboot2_0datasourceaop.mapper;

import org.apache.ibatis.annotations.Mapper;
import work.azhu.springboot2_0datasourceaop.model.UserInfo;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:43
 * Description:
 */
@Mapper
public interface UserInfoMapper {


    Integer insertUserInfo(UserInfo userInfo);

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUserInfoById(Integer id);

    UserInfo queryUserInfoByUserId(Integer id);

    List<UserInfo> queryAllUserInfoList();


}