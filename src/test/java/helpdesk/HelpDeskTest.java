package helpdesk;

import core.BaseSeleniumTest;
import helpers.TestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import readProperties.ConfigProvider;

import java.util.Date;
import java.text.SimpleDateFormat;

public class HelpDeskTest extends BaseSeleniumTest {
    @Test
    void checkTicket() {
        String title = TestValues.TEST_TITLE + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String body = TestValues.TEST_BODY;
        String email = TestValues.TEST_EMAIL;
        MainPage mainPage = new MainPage();
        TicketPage ticketPage = new MainPage()
                .createTicket(title, body, email)
                .openLoginPage()
                .auth(ConfigProvider.URL, ConfigProvider.DEMO_PASSWORD)
                .findTicket(title);
        Assertions.assertTrue(ticketPage.getTitle().contains(title));
        Assertions.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
        Assertions.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
    }
}
