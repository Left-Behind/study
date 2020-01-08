package work.azhu.springbootmybatis.service;

import work.azhu.springbootmybatis.pojo.UserInfo;

import java.util.List;

/**
 * @Author Azhu
 * @Date 2019/12/6 14:29
 * @Description
 */
public interface UserService {
    List<UserInfo> queryAllUserInfoList();
}
