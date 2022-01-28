import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        MessageProvider provider = MessageFactory.getProvider();
//        MessageRenderer renderer = MessageFactory.getRenderer();
//        renderer.render();
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();

    }
}
