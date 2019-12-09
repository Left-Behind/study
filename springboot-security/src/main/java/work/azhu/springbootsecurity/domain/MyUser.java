package work.azhu.springbootsecurity.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Azhu
 * @Date 2019/12/9 17:11
 * @Description: 登录用户测试类
 */
@Data
public class MyUser implements Serializable {

    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

}
