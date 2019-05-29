import com.stackroute.springJdbc.config.SpringJdbcConfig;
import com.stackroute.springJdbc.controller.SpringJdbcController;
import com.stackroute.springJdbc.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.stackroute.*")
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringJdbcConfig.class);
        ctx.refresh();

            SpringJdbcController springJdbcController =(SpringJdbcController) ctx.getBean("springJdbcController");
//        System.out.println(springJdbcController.insert());
        System.out.println(springJdbcController.getAll());

    }
}