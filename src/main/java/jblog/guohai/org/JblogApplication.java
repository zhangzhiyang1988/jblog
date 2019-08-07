package jblog.guohai.org;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableCaching
@EnableAsync
//@MapperScan("jblog.guohai.org.dao")
public class JblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JblogApplication.class, args);
    }

}
