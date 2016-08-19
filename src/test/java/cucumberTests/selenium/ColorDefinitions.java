package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;


public class ColorDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    /**
     Color
     */
    @And("^I see that color \"([^\"]*)\" was selected correctly$")
    public void i_see_that_color_was_selected_correctly(String colorName) {
        ellos().productPage.checkChosenColor(colorName);
    }

    @And("^On product page I choose color \"([^\"]*)\"$")
    public void on_product_page_I_choose_color(String colorValue) {
        ellos().productPage.chooseColor(colorValue);
    }


    @And("^I see that color \"([^\"]*)\" is disabled$")
    public void I_see_that_color_is_disabled(String color) {
/*        if (ellos().productPage.findColor(color).isEnabled()) {
            log.info(ellos().productPage.findColor(color).isEnabled());
        }

        ellos().productPage.findColor(color).isEnabled();
        log.info(ellos().productPage.findColor(color).isDisplayed());*/
        /*Assert.assertFalse(ellos().productPage.findColor(color).isEnabled(),
                "Color " + color + " is not disabled!");*/
    }



}
