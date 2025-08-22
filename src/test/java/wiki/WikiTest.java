package wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WikiTest {
    private final static String URL = "https://ru.wikipedia.org/wiki/java";

    @Test
    void openAllHrefs() {
        Selenide.open(URL);
        ElementsCollection hrefs = Selenide.$$x("//div[@id='toc']//a[@href]");
        List<String> links1 = new ArrayList<>();
        List<String> links2 = new ArrayList<>();
        List<String> links3 = new ArrayList<>();
        //1
        for (int i = 0; i < hrefs.size(); i++) {
            links1.add(hrefs.get(i).getAttribute("href"));
        }
        //2
        for (SelenideElement element : hrefs) {
            links2.add(element.getAttribute("href"));
        }
        //3
        hrefs.forEach(x -> links3.add(x.getAttribute("href")));

        for (String listUrl : links1) {
            Selenide.open(listUrl);
            System.out.println(listUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assert.assertEquals(currentUrl, listUrl);
        }

        while (!links1.isEmpty()) {
            int randomInt = new Random().nextInt(links1.size());
            Selenide.open(links1.get(randomInt));
            links1.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
        }
    }
}
