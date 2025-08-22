package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {
    private final static SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final static SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final static SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final static SelenideElement liveData = $x("//span[@data-qa='resume-personal-address']/ancestor::p");
    private final static SelenideElement tick = $x("//div[@data-qa='resume-contacts-phone']/span[1]");

    public static String GENDER = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String CONFIRMED_PHONE = "Подтверждённый номер";
    public static String READY_TO_RELOCATE = "Готовность к переезду";

    public HhResumePage(String url) {
        Selenide.open(url);
    }

    public Map<String, Object> getAttributes() {
        return new HashMap<String, Object>(){{
                put(GENDER, getGender());
                put(AGE, getAge());
                put(CITY, getCity());
                put(CONFIRMED_PHONE, isPhoneConfirmed());
                put(READY_TO_RELOCATE, isReadyToRelocate());
            }};
    }

    public int getAge() {
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    public String getGender() {
        return gender.text().equals("Мужчина") ? "М" : "Ж";
    }

    public String getCity() {
        return city.getText();
    }

    public boolean isReadyToRelocate() {
        return !liveData.getText().split(", ")[1].equals("не готова к переезду");
    }

    public boolean isPhoneConfirmed() {
        return tick.isDisplayed();
    }
}
