package work.azhu.springbootmybatisplus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.azhu.springbootmybatisplus.mapper.UserMapper;
import work.azhu.springbootmybatisplus.model.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> users = userMapper.selectList(null);//null表示无条件
        Assert.assertEquals(5,users.size()); //简单断言
        users.forEach(System.out::println);
    }


}
