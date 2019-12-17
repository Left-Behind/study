package work.azhu.auth.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/12/17 22:32
 **/
public class GitHubConfig {

    /**
     * 这里填写在GitHub上注册应用时候获得 CLIENT ID
     */
    public static final String CLIENT_ID = "Iv1.144ee59efd9fa91a";


    /**
     * 这里填写在GitHub上注册应用时候获得 CLIENT_SECRET
     */
    public static final String CLIENT_SECRET = "6cc114adf56b50bc65f9abd036574abb0a782306";

    /**
     *
     */
    public static final String CALLBACK = "http://www.azhu.work:8765/github/callback";

    /**
     * 获取code的url
     */
    public static final String CODE_URL = "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID + "&state=STATE&redirect_uri=" + CALLBACK + "";

    /**
     * 获取token的url
     */
    public static final String TOKEN_URL = "https://github.com/login/oauth/access_token?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=CODE&redirect_uri=" + CALLBACK + "";

    /**
     * 获取用户信息的url
     */
    public static final String USER_INFO_URL = "https://api.github.com/user?access_token=TOKEN";

}
