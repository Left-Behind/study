package work.azhu.springbootsecurity.validate.code;

import org.springframework.security.core.AuthenticationException;
/**
 * @Author Azhu
 * @Date 2019/12/10 19:33
 * @Description
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 5022575393500654458L;

    ValidateCodeException(String message) {
        super(message);
    }
}
