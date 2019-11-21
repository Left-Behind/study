package work.azhu.springboot2_0datasourceaop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = "com.azhu.springboot2_0datasourceaop.mapper")
public class Springboot20DatasourceAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot20DatasourceAopApplication.class, args);
	}

}
