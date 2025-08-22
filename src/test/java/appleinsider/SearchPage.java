package appleinsider;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ElementsCollection;


public class SearchPage {
    private final ElementsCollection articleTitles = Selenide.$$x("//h2[@class='entry-title']/a");

    /**
     * Возвращает href из первой найденной статьи
     */
    public String getHrefFromFirstArticle() {
        return articleTitles.first().getAttribute("href");
    }
}
