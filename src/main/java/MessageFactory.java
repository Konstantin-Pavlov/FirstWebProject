import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MessageFactory {

    private static MessageProvider provider;
    private static MessageRenderer renderer;

    static {
        Properties properties = new Properties();
        try (InputStream inputStream = MessageFactory
                .class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
            String MessageProviderClass = properties.getProperty("MessageProviderClass");
            String MessageRendererClass = properties.getProperty("MessageRendererClass");
            provider = (MessageProvider) Class.forName(MessageProviderClass).newInstance();
            renderer = (MessageRenderer) Class.forName(MessageRendererClass).getConstructor(MessageProvider.class).newInstance(provider);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static MessageProvider getProvider() {
        return provider;
    }

    public static MessageRenderer getRenderer() {
        return renderer;
    }
}
