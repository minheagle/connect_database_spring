import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import store.configuration.BeanConfiguration;
import store.myApp.MyApp;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        MyApp myApp = applicationContext.getBean("myApp", MyApp.class);
        myApp.run();
    }
}
