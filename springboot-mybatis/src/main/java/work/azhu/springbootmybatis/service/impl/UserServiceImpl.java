package work.azhu.springbootmybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.azhu.springbootmybatis.mapper.UserInfoMapper;
import work.azhu.springbootmybatis.pojo.UserInfo;
import work.azhu.springbootmybatis.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Azhu
 * @Date 2019/12/6 14:29
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryAllUserInfoList() {
        return userInfoMapper.queryAllUserInfoList();
    }
}
