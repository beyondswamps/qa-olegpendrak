package hh;

import core.BaseTest;
import junit.framework.Assert;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HhTest extends BaseTest {
    @Test
    public void checkAttributesHashMap() {
        HhResumePage hhResumePage = new HhResumePage(URL);

        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "Ж");
        expectedAttributes.put(HhResumePage.AGE, 38);
        expectedAttributes.put(HhResumePage.CITY, "Мончегорск");
        expectedAttributes.put(HhResumePage.CONFIRMED_PHONE, false);
        expectedAttributes.put(HhResumePage.READY_TO_RELOCATE, false);

        Map<String, Object> actualAttributes = hhResumePage.getAttributes();

        Assert.assertEquals(expectedAttributes, actualAttributes);

    }

    @Test
    public void checkAttributesClass() {
        HhResumePage hhResumePage = new HhResumePage(URL);
        Resume expectedAttributes = new Resume("Ж", 38, "Мончегорск", false, false);
        Resume actualAttributes = new Resume(
                hhResumePage.getGender(),
                hhResumePage.getAge(),
                hhResumePage.getCity(),
                hhResumePage.isPhoneConfirmed(),
                hhResumePage.isReadyToRelocate());

        Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes, actualAttributes));
    }

}
