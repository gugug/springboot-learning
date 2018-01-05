import com.gdufs.property.HomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 应用启动类
 * <p>
 */
@SpringBootApplication
@ComponentScan(value = {"com.gdufs"})
public class Application implements CommandLineRunner {

    @Autowired
    private HomeProperties homeProperties;

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n" + homeProperties.toString());
        System.out.println();
    }
}
