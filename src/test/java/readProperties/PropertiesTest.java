package readProperties;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest extends BaseTest {
    @Test
    void readProperties() throws IOException
    {
        Properties props = System.getProperties();
        props.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println(urlFromProperty);
    }

    @Test
    void readFromConf() {
        String urlFromConfig = ConfigProvider.URL;
        System.out.println(urlFromConfig);
        Boolean isDemoAdmin = ConfigProvider.IS_DEMO_ADMIN;
        System.out.println(isDemoAdmin);
        if (ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")) {
            System.out.println("admin is truely admin");
        } else {
            System.out.println("not admin");
        }
    }
}
