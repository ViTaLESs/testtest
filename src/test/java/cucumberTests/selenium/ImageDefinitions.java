package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by lavi on 3/4/2016.
 */
public class ImageDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /**
     Preconditions
     */
    @Given("^I check that I switch to PDP correct$")
    public void i_check_that_I_switch_to_PDP_correct() {
        Assert.assertTrue(ellos().productPage.isSwitchToProductPageCorrect(), "I switch to product page INCORRECT!");
    }

    @Given("^I check that All colors are represented in the form of rings$")
    public void i_check_that_All_colors_are_represented_in_the_form_of_rings() {
        Assert.assertTrue(ellos().web.getElement("ColorList").getCssValue("border-radius").equals("50%"),
                "Colors icons are NOT represented in the form of rings!");
    }


    /**
     Steps
     */
    @When("^I leaf through the right to see the next image$")
    public void i_leaf_through_the_right_to_see_the_next_image() {
        ellos().productPage.leafThrough("ImageContainer_ArrowRight");
    }

    @When("^I leaf through the left to see the next image$")
    public void i_leaf_through_the_left_to_see_the_next_image() {
        ellos().productPage.leafThrough("ImageContainer_ArrowLeft");
    }

    @When("^On product page I click on product image$")
    public void on_product_page_I_click_on_product_image() {
        ellos().productPage.clickProductImage();
    }


    /**
     Verify
     */
    @Then("^Image Container that holds slides, product image and image top-bar are shown$")
    public void image_Container_that_holds_slides_product_image_and_image_top_bar_are_shown() {
        Assert.assertTrue(ellos().productPage.isImageContainerShownCorrect(), "Image Container Shown INCORRECT!");
    }

    @Then("^The product image is shown on the center of the container$")
    public void the_product_image_is_shown_on_the_center_of_the_container() {
        Assert.assertTrue(ellos().productPage.isImageShownOnTheCenterOfContainer(), "Image does not Shown On The Center Of Container; " +
                        "lock at left/right CSS_Value of image wrapper!");
    }

    @Then("^The product image has the same color which was selected on color panel$")
    public void the_product_image_has_the_same_color_which_was_selected_on_color_panel() {
        Assert.assertTrue(ellos().productPage.isImageHasTheSameColorWhichWasSelectedOnColorPanel());
    }

    @Then("^Image Container top-bar contains zoom, full screen, close icons$")
    public void image_Container_top_bar_contains_zoom_full_screen_close_icons() {
        Assert.assertTrue(ellos().productPage.isImageContainerButtonsShown(), "Image Container Buttons Shown INCORRECT!");
    }

    @Then("^I close image$")
    public void i_close_image() {
        ellos().productPage.closeImageContainer();
    }

    @Then("^I close image using ESCAPE$")
    public void i_close_image_using_ESCAPE$() {
        ellos().productPage.closeImageContainerUsingESCAPE();
    }

//I see that color "([^"]*)" is selected correctly
    @Then("^I see that the \"([^\"]*)\" color is selected correctly and the picture is displayed correctly$")
    public void i_see_that_the_color_of_the_product_has_been_selected_correctly(String colorValue) {
        ellos().productPage.checkingSuccessfullyChangeTheColor(colorValue);
    }

    @Then("^The alternative images are shown correctly$")
    public void the_alternative_images_are_shown_correctly() {
        ellos().productPage.checkingAlternativeImagesShownCorrectly();
    }

    @Then("^I see that I can slide down to see the rest of the images$")
    public void i_see_that_I_can_slide_down_to_see_the_rest_of_the_images() {
        ellos().productPage.checkAlternativeImagesSlide();
    }

    @Then("^I click on one of the alternative images$")
    public void i_click_on_one_of_the_alternative_images() {
        ellos().productPage.clickOnAlternativeImage("AlternativeImage_SecondImage_forClick");
    }

    @Then("^I check that zoom button works correct$")
    public void i_check_that_zoom_button_works_correct() {
        ellos().productPage.checkThatZoomButtonWorksCorrect();
    }

    @Then("^I will see that the big image is changed to the alternative image$")
    public void i_will_see_that_the_big_image_is_changed_to_the_alternative_image() {
        ellos().productPage.checkBigImageChangedToTheAlternativeImage();
    }

    @Then("^I check that zoom by click works correct$")
    public void i_check_that_zoom_by_click_works_correct() {
        ellos().productPage.checkThatZoomByClickWorksCorrect();
    }

    @Then("^I click on zoom button$")
    public void i_click_on_zoom_button() {
        ellos().productPage.clickOnZoomInButton();
    }

    @Then("^I check that full screen works correct$")
    public void i_check_that_full_screen_works_correct() {
        ellos().productPage.checkThatFullScreenWorksCorrect();
    }

}
