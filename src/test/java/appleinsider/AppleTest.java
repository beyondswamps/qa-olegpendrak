package appleinsider;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class AppleTest extends BaseTest {
    private static final String BASE_URL = "https://appleinsider.ru/";
    private static final String SEARCH_STRING = "Чем отличается iPhone 15 от iPhone 14";
    private final static String EXPECTED_WORD = "iphone-15";

    @Test
    public void checkHref() {
        Assert.assertTrue(new MainPage(BASE_URL)
                .search(SEARCH_STRING)
                .getHrefFromFirstArticle()
                .contains(EXPECTED_WORD));
    }
}
