import com.mapper.UserInfoMapper;
import com.pojo.UserInfo;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

/**
 * @Author Azhu
 * @Date 2019/12/6 11:20
 * @Description
 */
public class testUserInfo {

    @Test
    public void insert(){
        SqlSession session=null;
        try{
            session= MyBatisUtil.getSesssion();
            UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
            UserInfo userInfo=new UserInfo();
            userInfo.setUserName("Mapper-insert");
            userInfoMapper.insertUserInfo(userInfo);
        }catch (Exception e){
            throw e;
        }
        finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void sqlSession(){
        SqlSession session=null;
        try{
            session= MyBatisUtil.getSesssion();
            UserInfo userInfo=new UserInfo();
            userInfo.setUserName("sqlSession-insert");
            //这种方法必须保证xml文件里不能有两个相同的id,即方法名insertUserInfo
            session.insert("insertUserInfo",userInfo);
        }catch (Exception e){
            throw e;
        }
        finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void testMap(){
        SqlSession session=null;
        try{
            session= MyBatisUtil.getSesssion();
            UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
            Map map=userInfoMapper.queryUserMap(1);
            System.out.println(map.toString());
        }catch (Exception e){
            throw e;
        }
        finally {
            session.commit();
            session.close();
        }
    }
}
