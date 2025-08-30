package helpdesk;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketPage {
    @FindBy(xpath = "//th[text()='Submitter E-Mail'/following::td[1]")
    private WebElement email;

    @FindBy(xpath = "//h3")
    private WebElement title;

    @FindBy(xpath = "//td[@id='ticket-description']//p")
    private WebElement body;

    public String getEmail() {
        return email.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getBody() {
        return body.getText();
    }
}
