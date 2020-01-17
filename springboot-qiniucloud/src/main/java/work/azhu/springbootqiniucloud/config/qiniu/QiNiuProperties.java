package work.azhu.springbootqiniucloud.config.qiniu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Azhu
 * @Date 2020/1/13 11:40
 * @Description
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
@Data
public class QiNiuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String path;
}
