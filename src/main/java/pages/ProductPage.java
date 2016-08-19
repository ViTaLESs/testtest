package pages;

import utils.ClassNameUtil;
import utils.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverWrapper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;


public class ProductPage extends Page{

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    protected Util util;


    public ProductPage(WebDriverWrapper driver) {
        super(driver);
        util = new Util(driver);
    }



    /**
     * PDP
     */
    public void addProductToBasketAndCheckIt() {
        //is needed cause PDP load in interesting way with strange short Size_DropDown
        //and that's why  WebDriverException: Other element would receive the click: <span class="fancy-select-text">...</span>
        web.waitForElementPresent("ProductSize_DropDownButton");

        web.waitForElementPresent("AddProductToBasketButton");
        web.waitForElementToBeClickable("AddProductToBasketButton");
        web.clickButton("AddProductToBasketButton");

        web.waitForElementPresent("TillKassanText_ProductAddedSuccessfully");
        Assert.assertTrue(web.isElementPresent("TillKassanText_ProductAddedSuccessfully"),
                "The product has been INCORRECTLY ADDED TO THE CART!\n" +
                        //maybe not needed next line???
                        "TillKassanPopUpLink Text - " + web.getElementText("TillKassanPopUp_Link"));
        log.info("The product has been successfully added to the cart");

        //wait for the automatic closing of the popup window is successfully added product
        web.waitForElementNotVisible("TillKassanText_ProductAddedSuccessfully");
    }

    //TODO
    //TODO
    //TODO
    public void switchToMainPage() {
        //web.refreshPage();

        web.waitForElementPresent("ProductPageLogo");
        web.waitForElementToBeClickable("ProductPageLogo");
        web.clickLink("ProductPageLogo");

        Assert.assertTrue(web.isElementPresent("Logo"), "Switch from Product page to Main page was INCORRECT!");
        log.info("Switch from Product page to Main page was correct");
    }

    public boolean isAllIProductAttributesPresent_StandardProduct() {
        boolean totalResult = true;

        String []massOfAttributes_namesOfLocators = {
                // sku, name, price, currency
                "ProductArticle", "ProductName", "ProductPrice", "ProductCurrency",
                // AddProductToBasket and AddProductToWishList buttons and Images
                "AddProductToBasketButton", "AddProductToWishListButton", "ProductImageOnPDP", "AlternativeImages",
                // Colors and size buttons
                "DetailedColorAria", "SmallSelectedColorLabel", "ProductSize_DropDownButton",
                // Reade more
                "ReadMoreLink", "TruncatedDescription_NearReadMoreLink",
                // small staff
                // ReviewsLink will absent at nearest release!!!
                "ProductInfoRatingLink", "PDPMonthlyPayment", "ProductInfoRatingVotes", "SizeGuideLink", /*"ReviewsLink",*/ "ProductExtraLinks", "ProductTerms",
                // Tabs
                "ProductDescriptionTab", "DeliveryTab", "SizeGuideTab",
                "ProductDescription_ActiveBlock"};

        for (String massOfAttributes_namesOfLocator : massOfAttributes_namesOfLocators) {
            if (web.isElementPresent(massOfAttributes_namesOfLocator)) {
                log.info("\t\tElement - " + massOfAttributes_namesOfLocator + " is present on PDP");
            } else {
                log.error("Element - " + massOfAttributes_namesOfLocator + " is NOT PRESENT on PDP!\n");
                totalResult = false;
            }
        }

        return totalResult;
    }

    public boolean isAllIProductAttributesPresent_FabricProduct() {
        boolean totalResult = true;

        String []massOfAttributes_namesOfLocators = {
                // sku, name, price, currency
                "ProductArticle", "ProductName", "ProductPrice", "ProductCurrency",
                // AddProductToBasket and AddProductToWishList buttons and Images
                "AddProductToBasketButton", "AddProductToWishListButton", "ProductImageOnPDP", "AlternativeImages",
                // Colors and size buttons
                "DetailedColorAria", "SmallSelectedColorLabel",
                // Reade more
                "ReadMoreLink", "TruncatedDescription_NearReadMoreLink",
                // small staff
                // ReviewsLink will absent at nearest release!!!
                //PDPMonthlyPayment is not present for this specific fabric product 1077230-13-0
                "ProductInfoRatingLink", /*"PDPMonthlyPayment",*/ "ProductInfoRatingVotes", "SizeGuideLink", /*"ReviewsLink",*/ "ProductExtraLinks", "ProductTerms",
                // Tabs
                "ProductDescriptionTab", "DeliveryTab", "SizeGuideTab",
                "ProductDescription_ActiveBlock"};

        for (String massOfAttributes_namesOfLocator : massOfAttributes_namesOfLocators) {
            if (web.isElementPresent(massOfAttributes_namesOfLocator)) {
                log.info("\t\tElement - " + massOfAttributes_namesOfLocator + " is present on PDP");
            } else {
                log.error("Element - " + massOfAttributes_namesOfLocator + " is NOT PRESENT on PDP!\n");
                totalResult = false;
            }
        }

        return totalResult;
    }

    public boolean isAllIProductAttributesPresent() {
        boolean totalResult = true;

        String []massOfAttributes_namesOfLocators = {
                // sku, name, price, currency
                "ProductArticle", "ProductName", "ProductPrice", "ProductCurrency",
                // AddProductToBasket and AddProductToWishList buttons and Images
                "AddProductToBasketButton", "AddProductToWishListButton", "ProductImageOnPDP", "AlternativeImages",
                // Colors and size buttons
                "DetailedColorAria", "SmallSelectedColorLabel", "FabricProduct_ProductInStockLabel",
                // Reade more
                "ReadMoreLink", "TruncatedDescription_NearReadMoreLink",
                // small staff
                // ReviewsLink will absent at nearest release!!!
                "ProductInfoRatingLink", "PDPMonthlyPayment", "ProductInfoRatingVotes", "SizeGuideLink", /*"ReviewsLink",*/ "ProductExtraLinks", "ProductTerms",
                // Tabs
                "ProductDescriptionTab", "DeliveryTab", "SizeGuideTab",
                "ProductDescription_ActiveBlock"};

        for (String massOfAttributes_namesOfLocator : massOfAttributes_namesOfLocators) {
            if (web.isElementPresent(massOfAttributes_namesOfLocator)) {
                log.info("\t\tElement - " + massOfAttributes_namesOfLocator + " is present on PDP");
            } else {
                log.error("Element - " + massOfAttributes_namesOfLocator + " is NOT PRESENT on PDP!\n");
                totalResult = false;
            }
        }

        return totalResult;
    }

    public void double_clickOnButtonAddToCart() {
        web.waitForElementPresent("AddProductToBasketButton");
        web.clickButton("AddProductToBasketButton");

        web.waitForElementPresent("TillKassanText_ProductAddedSuccessfully");

        if (web.isElementPresent("TillKassanText_ProductAddedSuccessfully")) {
            log.info("The product has been successfully added to the cart");
            log.info("TillKassanPopUpLink - " + web.isElementPresent("TillKassanPopUp_Link"));
            log.info("TillKassanPopUpLink Text - " + web.getElementText("TillKassanPopUp_Link"));

            sleep(5000);

            //like  method addProductToBasketAndCheckIt() in the method addProductToBasketAndCheckIt()
            addProductToBasketAndCheckIt();
        } else {
            log.error("The product has been INCORRECTLY ADDED TO THE CART!\n");
            log.error("TillKassanPopUpLink - " + web.isElementPresent("TillKassanPopUp_Link"));
            log.error("TillKassanPopUpLink Text - " + web.getElementText("TillKassanPopUp_Link"));
            Assert.fail();
        }
    }

    public void checkingProductTabAndBlocks() {
        String []tabsOnPDP = {"ProductDescriptionTab", "PaymentTab", "DeliveryTab", "SizeGuideTab"};
        String []activeBlockOnPDP = {"ProductDescription_ActiveBlock", "Payment_ActiveBlock", "Delivery_ActiveBlock", "SizeGuide_ActiveBlock"};

        for (int i = 0; i < tabsOnPDP.length; i++) {
            sleep(2000);
            web.clickButton(tabsOnPDP[i]);
            sleep(2000);
            Assert.assertTrue(web.isElementPresent(activeBlockOnPDP[i]),
                    "Element - " + tabsOnPDP[i] + " is NOT PRESENT on PDP!\n");
        }
    }



    /**
     * Size
     */
    public void selectSize(String brandSizeValue) {
        clickOnSizeDropDown();
        web.waitForElementPresent("ListOfProductSize");

        if (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "']")).isDisplayed()) {
            webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "']")).click();
        } else {
            web.scrollPageToElement("ListOfProductSize");
            webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "']")).click();
        }

        web.pressPageUp("ProductPageLogo");
    }

    public void specifyLengthForFabricProduct(String inputValue) {
        web.input("FabricProduct_InputField_LengthOfProduct", inputValue);
    }

    public void checkThatSizeIsOutOfStock(String brandSizeValue) {
        clickOnSizeDropDown();
        web.waitForElementPresent("ListOfProductSize");

        if (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock")).isDisplayed()
                //TODO
                && webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock")).isEnabled()
                /*//TODO
                && webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock span.stockText")).getText().equals("Sold out")*/
                ) {
            log.info("brandSizeValue - " + brandSizeValue + " is Out of stock and size is disabled");
        } else {
            log.error("CheckThatSizeIsOutOfStock has revealed problems!\n" +
                    "brandSizeValue isDisplayed - " + (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock")).isDisplayed()) + "\n" +
                    "brandSizeValue isEnabled - " + (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock")).isEnabled()) + "\n" +
                    "brandSizeValue equals 'Sold out' - " + (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock span.stockText")).getText().equals("Sold out")));
            Assert.fail("CheckThatSizeIsOutOfStock has revealed problems!\n" +
                    "brandSizeValue isDisplayed - " + (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock")).isDisplayed()) + "\n" +
                    "brandSizeValue isEnabled - " + (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock")).isEnabled()) + "\n" +
                    "brandSizeValue equals 'Sold out' - " + (webDriverWrapper.findElement(By.cssSelector("li[data-raw-value$='-" + brandSizeValue + "'].is-muted.outOfStock span.stockText")).getText().equals("Sold out")));
        }
    }

    public void clickOnSizeDropDown() {
        web.clickButton("ProductSize_DropDownButton");
    }

    public void double_clickOnSizeDropDown() {
        web.clickButton("ProductSize_DropDownButton");
        web.clickButton("ProductSize_DropDownButton");
    }

    public boolean isSizeListShownCorrect() {
        if (web.isElementPresent("ListOfProductSize")
                && web.isElementPresent("ListOfProductSize_Header")
                && web.isAllElementsPresent("ListOfProductSize_InStockLabel")
                && web.isAllElementsPresent("ListOfProductSize_ProductsSize")
                && web.isAllElementsPresent("ListOfProductSize_ProductsReferenceSize")) {
            log.info("ListOfProductSize shown correct");
            return true;
        } else {
            log.error("ListOfProductSize shown INCORRECT!" + "" +
                    "ListOfProductSize - " + web.isElementPresent("ListOfProductSize") + "\n" +
                    "ListOfProductSize_Header - " + web.isElementPresent("ListOfProductSize_Header") + "\n" +
                    "ListOfProductSize_InStockLabel - " + web.isAllElementsPresent("ListOfProductSize_InStockLabel") + "\n" +
                    "ListOfProductSize_ProductsSize - " + web.isAllElementsPresent("ListOfProductSize_ProductsSize") + "\n" +
                    "ListOfProductSize_ProductsReferenceSize - " + web.isAllElementsPresent("ListOfProductSize_ProductsReferenceSize") + "\n");
            return false;
        }
    }

    public void checkChangingSize(String brandSizeValue, String stockLabelValue) {
        web.waitForElementPresent("SelectedValue_Of_ProductBrandSize");

        if (web.getElementText("SelectedValue_Of_ProductBrandSize").contains(brandSizeValue)
                && web.getElementText("SelectedValue_Of_ProductLabel").contains(stockLabelValue)) {

            log.info("Size - " + brandSizeValue + ", was selected correct");
        } else {
            log.error("Size - " + brandSizeValue + ", was selected INCORRECT!" + "\n" +
                    "SelectedValue_Of_ProductSize - " + web.getElementText("SelectedValue_Of_ProductBrandSize").contains(brandSizeValue) + "\n" +
                    "SelectedValue_Of_ProductInStockLabel - " + web.getElementText("SelectedValue_Of_ProductBrandSize").contains(stockLabelValue) + "\n");

            Assert.fail("Size - " + brandSizeValue + ", was selected INCORRECT!" + "\n" +
                    "SelectedValue_Of_ProductSize - " + web.getElementText("SelectedValue_Of_ProductBrandSize").contains(brandSizeValue) + "\n" +
                    "SelectedValue_Of_ProductInStockLabel - " + web.getElementText("SelectedValue_Of_ProductBrandSize").contains(stockLabelValue) + "\n");
        }
    }

    //
    // Method for checking DEFAULT size Value
    //
    public boolean isLabelInStockPresentOnSelectedSize(String labelValue) {
        if (web.isElementPresent("DEFAULTValue_Of_ProductInStockLabel")
                && web.getElementText("DEFAULTValue_Of_ProductInStockLabel").equals(labelValue)){
            log.info("Product " + labelValue + " label shown correct");
            return true;
        } else {
            log.error("Product " + labelValue + " label shown INCORRECT!" + "\n" +
                    "SelectedValue_Of_Product " + labelValue + " Label - " + web.isElementPresent("DEFAULTValue_Of_ProductInStockLabel") + "\n" +
                    "Is correct text - " + web.getElementText("DEFAULTValue_Of_ProductInStockLabel").equals(labelValue) + "\n");
            return false;
        }
    }

    public void checkingFabricProductLabel(String lableValue) {
        Assert.assertTrue(web.isElementPresent("FabricProduct_ProductInStockLabel")
                && web.getElementText("FabricProduct_ProductInStockLabel").equals(lableValue),
                "is FabricProduct Label present - " + web.isElementPresent("FabricProduct_ProductInStockLabel") + "\n" +
                "is text correct - " + web.getElementText("FabricProduct_ProductInStockLabel").equals(lableValue));

        log.info("Label in FabricProduct is correct");
    }

    public void check_SignOK_ForLengthFabricProduct() {
        web.clickButton("FabricProduct_ProductInStockLabel");

        web.waitForElementPresent("FabricProduct_SingOK_LengthOfProduct");

        Assert.assertTrue(web.isElementPresent("FabricProduct_SingOK_LengthOfProduct"),
                "Product length was specified INCORRECTLY!Sing-OK is NOT present!");

        log.info("Product length was specified correctly; Sing-OK is present");
    }



    /**
     * Color
     */
    public void checkChosenColor(String colorName) {
        Assert.assertTrue((isColorButtonSelected(colorName)
                && isSmallColorLabelCorrect(colorName)
                && isImageHasTheSameColorWhichWasSelectedOnColorPanel()), "Color - " + colorName + ", was selected INCORRECT!");

        log.info("Color - " + colorName + ", was selected correct");
    }

    public boolean isColorButtonSelected(String colorName) {
        if (web.getElement("SelectedColor").getAttribute("data-article-color").equals(colorName)){
            log.info("The color button Selected correct");
            return true;
        } else {
            log.error("The color button Selected INCORRECT!");
            log.error("data-article-color = " + web.getElement("SelectedColor").getAttribute("data-article-color"));
            return false;
        }
    }

    public boolean isSmallColorLabelCorrect(String colorName) {
        if (web.getElementText("SmallSelectedColorLabel").equals(colorName)){
            log.info("The Small Color Label shown correct");
            return true;
        } else {
            log.error("The Small Color Label shown INCORRECT!");
            return false;
        }
    }

    public void chooseColor(String colorName) {
        //checking if the color hidden by Button_ExpandMoreColors
        if (!findColor(colorName).isDisplayed() && web.isElementPresent("Button_ExpandMoreColors")) {
            web.clickButton("Button_ExpandMoreColors");

            sleep(3000);
        }

        findColor(colorName).click();
        log.info("Color " + colorName + " was selected");
    }

    public WebElement findColor(String colorName){
        return webDriverWrapper.findElement(By.cssSelector("[data-article-color='" + colorName + "']"));
    }

    public boolean isImageHasTheSameColorWhichWasSelectedOnColorPanel() {
        String productImageHrefValue = web.getElement("ProductImageOnPDP_forChecking").getAttribute("href");
        String selectedColorLabel = web.getElementText("SmallSelectedColorLabel");
        String findSelectedColor = findColor(selectedColorLabel).getAttribute("data-article-color-id");

        if (productImageHrefValue.contains(findSelectedColor)) {
            log.info("Image has the same color which was selected On Color Panel");
            return true;
        } else {
            log.error("Image has NOT the same color which was selected On Color Panel!\n");
            return false;
        }
    }

    public void checkingSuccessfullyChangeTheColor(String colorValue) {

        if (web.getElementText("SmallSelectedColorLabel").equals(colorValue)) {
            log.info("Small color label shown correct");
        } else {
            log.error("Small color label shown INCORRECT!\n");
        }

        WebElement selectedColorLocator = web.getElement("SelectedColor");

        if (selectedColorLocator.getAttribute("data-article-color").equals(colorValue)) {
            log.info("The color of the product has been successfully changed to - " + colorValue);
        } else {
            log.error("Is selected incorrect color -- " + selectedColorLocator.getAttribute("data-article-color") + "! \n");
            Assert.fail("Is selected incorrect color -- " + selectedColorLocator.getAttribute("data-article-color") + "!");
        }

        String colorID = selectedColorLocator.getAttribute("data-article-color-id");
        WebElement selectedImageLocator = web.getElement("ProductImageOnPDP_forChecking");

        if (selectedImageLocator.getAttribute("href").contains(colorID)) {
            log.info("Product image has been changed to a correct color - " + colorValue);
        } else {
            log.error("Product image has been changed incorrect\n");
            log.error("Image color code - " + colorID + " has been changed incorrect\n");
            log.error("Is Image contains code - " + selectedImageLocator.getAttribute("href").contains(colorID));
            Assert.fail("Product image has been changed INCORRECT!");
        }
    }




    /**
     * Image
     */
    public boolean isSwitchToProductPageCorrect() {
        if (web.isElementPresent("ProductImageOnPDP") && web.isElementPresent("ProductName") && web.isElementPresent("AddProductToBasketButton")) {
            log.info("I switch to product page correct");
            return true;
        } else {
            return false;
        }
    }

    public void clickProductImage() {
        web.waitForElementToBeClickable("ProductImageOnPDP");

        web.clickButton("ProductImageOnPDP");
    }

    public boolean isImageContainerShownCorrect() {
        if (web.isElementPresent("ImageContainer_Image")
                && web.isElementPresent("ImageContainer_Top-Bar")
                && web.isElementPresent("ImageContainer_ArrowLeft")
                && web.isElementPresent("ImageContainer_ArrowRight")) {
            log.info("I switch to product page correct");
            return true;
        } else {
            return false;
        }
    }

    //At present time left and right CSS styles has Value equals "0px"
    //by which is provided the correct location of the picture in the center of wrapper
    public boolean isImageShownOnTheCenterOfContainer() {
        String CSS_Value = "0px";
        WebElement wrapper = web.getElement("ImageContainer_ImageWrapper");

        return wrapper.getCssValue("left").equals(CSS_Value) && wrapper.getCssValue("right").equals(CSS_Value);
    }

    public boolean isImageContainerButtonsShown() {
        if (web.isElementPresent("ImageContainer_Top-Bar")
                && web.isElementPresent("ImageContainer_ImageCounter")
                && web.isElementPresent("ImageContainer_FullscreenButton")
                && web.isElementPresent("ImageContainer_ZoomButton")
                && web.isElementPresent("ImageContainer_CloseButton")) {
            log.info("Image Container Buttons Shown correct");
            return true;
        } else {
            return false;
        }
    }

    public void closeImageContainer() {
        web.waitForElementPresent("ImageContainer_Top-Bar");

        web.moveToElementAndClick("ImageContainer_Top-Bar", "ImageContainer_CloseButton");

        if (web.isElementPresent("ImageContainer_Image")) {
            web.waitForElementDisappear("ImageContainer_Image");
        }

        web.waitForElementPresent("ProductPageLogo");
        web.waitForElementToBeClickable("ProductPageLogo");

        Assert.assertFalse(web.isElementPresent("ImageContainer_Image"), "ImageContainer_CloseButton works incorrectly in this time!");
    }

    public void closeImageContainerUsingESCAPE() {
        web.pressESCAPEKey("ImageContainer_CloseButton");
        web.waitForElementDisappear("ImageContainer_Image");
    }

    public void checkingAlternativeImagesShownCorrectly() {

        boolean marker = false;

        List<WebElement> alternativeImagesList = web.getElements("AlternativeImages");
        String colorID = web.getElement("SelectedColor").getAttribute("data-article-color-id");

        for (WebElement element: alternativeImagesList) {
            if (element.getAttribute("href").contains(colorID)) {
                marker = true;
            } else {
                marker = false;
            }
        }
        log.info("Alternative Images Shown Correctly");

        Assert.assertTrue(marker, "Some alternative Images shown INCORRECT! colorID - " + colorID + "; ");
    }

    public void checkAlternativeImagesSlide() {
        if (web.isElementPresent("AlternativeImagesSlideDown")) {
            web.waitForElementToBeClickable("AlternativeImagesSlideDown");
            web.clickButton("AlternativeImagesSlideDown");
        } else {
            log.error("Slider Down of Alternative Images was not shown!\n");
        }

        web.waitForElementPresent("AlternativeImages_LastImage");
        Assert.assertTrue(web.isElementPresent("AlternativeImages_LastImage"), "Slider works incorrect! Last images is not shown!\n");

        sleep(2000);
        if (web.isElementPresent("AlternativeImagesSlideUP")) {
            web.waitForElementToBeClickable("AlternativeImagesSlideUP");
            web.clickButton("AlternativeImagesSlideUP");
        } else {
            log.error("Slider Down of Alternative Images was not shown!\n");
        }

        Assert.assertTrue(web.isElementPresent("AlternativeImages_FirstImage"), "Slider works incorrect! First images is not shown!\n");
    }

    public void clickOnAlternativeImage(String alternativeImageLocator) {
        web.waitForElementPresent(alternativeImageLocator);
        web.waitForElementToBeClickable(alternativeImageLocator);
        web.clickLink(alternativeImageLocator);
    }

    public void checkBigImageChangedToTheAlternativeImage() {
        web.waitForElementPresent("ProductImageOnPDP_forChecking");

        String activeAlternativeImage = web.getElement("ActiveAlternativeImage").getAttribute("href");
        String productImageOnPDP = web.getElement("ProductImageOnPDP_forChecking").getAttribute("href");

        if (activeAlternativeImage.equals(productImageOnPDP)) {
            log.info("Alternative image change main product image correctly");
        } else {
            log.error("Alternative image change main product image INCORRECTLY!\n");
            log.error("activeAlternativeImage - " + activeAlternativeImage);
            log.error("productImageOnPDP - " + productImageOnPDP);
            Assert.fail("Alternative image change main product image INCORRECTLY!");
        }
    }

    public void leafThrough(String imageContainer_Arrow) {
        String imageID_before =  web.getElementText("ImageContainer_ImageCounter");

        web.waitForElementPresent(imageContainer_Arrow);
        web.waitForElementToBeClickable(imageContainer_Arrow);
        sleep(3000);

        web.moveToElementAndClick(imageContainer_Arrow, imageContainer_Arrow);
        web.waitForElementPresent("ImageContainer_ImageCounter");

        String imageID_after = web.getElementText("ImageContainer_ImageCounter");

        if (imageID_before.equals(imageID_after)) {
            log.error("Leaf Through The Right works INCORRECTLY!\n");
            log.error("imageID_before - " + imageID_before);
            log.error("imageID_after - " + imageID_after);

            Assert.fail("Leaf Through The Right works INCORRECTLY!");
        } else {
            log.info(imageContainer_Arrow + " works correctly");
        }
    }

    public void checkThatZoomButtonWorksCorrect() {
        sleep(3000);
        web.moveToElementAndClick("ImageContainer_Top-Bar", "ImageContainer_ZoomButton");
        web.waitForElementPresent("ImageContainer_ZoomedOUTButton");

        Assert.assertFalse(web.isElementPresent("ImageContainer_ZoomINButton"), "Zoom increase works incorrect!");
        log.info("Zoom in works correctly - " + web.isElementPresent("ImageContainer_ZoomINButton"));

        sleep(3000);
        web.moveToElementAndClick("ImageContainer_Top-Bar", "ImageContainer_ZoomButton");
        web.waitForElementPresent("ImageContainer_ZoomINButton");

        Assert.assertFalse(web.isElementPresent("ImageContainer_ZoomedOUTButton"), "Zoom decrease works incorrect!");
        log.info("Zoom out works correctly - " + web.isElementPresent("ImageContainer_ZoomedOUTButton"));
        log.info("Zoom button works correctly!");
    }

    public void clickOnZoomInButton() {
        sleep(3000);
        web.moveToElementAndClick("ImageContainer_Top-Bar", "ImageContainer_ZoomButton");
        web.waitForElementPresent("ImageContainer_ZoomedOUTButton");

        Assert.assertFalse(web.isElementPresent("ImageContainer_ZoomINButton"), "Zoom increase works incorrect!");
        log.info("Zoom in works correctly - " + web.isElementPresent("ImageContainer_ZoomINButton"));
    }

    public void checkThatZoomByClickWorksCorrect() {
        //Zoom In
        web.clickLink("ImageContainer_Image");
        web.waitForElementPresent("ImageContainer_ZoomedIN_Img");
        Assert.assertTrue(web.isElementPresent("ImageContainer_ZoomedIN_Img"), "Zoom increase works incorrect!");
        log.info("Zoom in works correctly");

        //Zoom OUT
        web.clickLink("ImageContainer_Image");
        web.waitForElementPresent("ImageContainer_ZoomedOUT_Img");
        Assert.assertTrue(web.isElementPresent("ImageContainer_ZoomedOUT_Img"), "Zoom decrease works incorrect!");
        log.info("Zoom out works correctly");
        log.info("Zoom by click works correctly!");
    }

    public void checkThatFullScreenWorksCorrect() {
        sleep(3000);
        web.moveToElementAndClick("ImageContainer_Top-Bar", "ImageContainer_FullscreenButton");
        web.waitForElementPresent("ImageContainer_FullscreenOFF");

        Assert.assertFalse(web.isElementPresent("ImageContainer_FullscreenON"), "FullScreen increase works incorrect!");
        log.info("FullScreen in works correctly - " + web.isElementPresent("ImageContainer_FullscreenON"));

        sleep(3000);
        web.moveToElementAndClick("ImageContainer_Top-Bar", "ImageContainer_FullscreenButton");
        web.waitForElementPresent("ImageContainer_FullscreenON");

        Assert.assertFalse(web.isElementPresent("ImageContainer_FullscreenOFF"), "FullScreen decrease works incorrect!");
        log.info("FullScreen out works correctly - " + web.isElementPresent("ImageContainer_FullscreenOFF"));
        log.info("FullScreen button works correctly!");
    }



    /**
     * AddProductToWishList
     */
    public void clickOnButtonAddProductToWishList() {
        web.waitForElementPresent("AddProductToWishListButton");
        web.clickButton("AddProductToWishListButton");
    }



    /**
     *    For one product
     */
    public void checkingTheCorrectnessOfAddProductToMiniCart(String quantityOfProduct) {
        if (isProductNameCorrectInMiniCart()
                && isProductBrandSizeCorrectInMiniCart()
                && isPriceCorrectInMiniCart()
                && isCurrencyCorrectInMiniCart()
                && isTotalAmountCorrect_ForOneProduct_OnMiniCart()
                && isQuantityOfProductCorrectInMiniCart(quantityOfProduct)) {
            log.info("Product has been added to the cart successfully");
        } else {
            Assert.fail("Product has been added to the cart INCORRECTLY!");
        }
    }

    public boolean isProductNameCorrectInMiniCart() {
        if (web.getElementText("ProductName").toLowerCase()
                .equals(web.getElementText("TillKassanProductName").toLowerCase())) {
            log.info("ProductName shown correct");
            return true;
        } else {
            log.error("ProductName shown INCORRECT!\n");
            log.error("ProductName on PDP - " + web.getElementText("ProductName").toLowerCase());
            log.error("ProductName on Minicart - " + web.getElementText("TillKassanProductName").toLowerCase());
            return false;
        }
    }

    public boolean isProductBrandSizeCorrectInMiniCart() {
        if (web.getElementText("SelectedValue_Of_ProductBrandSize")
                .contains(web.getElementText("TillKassanProductBrandSize"))) {
            log.info("Product BrandSize shown correct");
            return true;
        } else {
            log.error("Product BrandSize shown INCORRECT!\n");
            log.error("Product BrandSize on PDP - " + web.getElementText("SelectedValue_Of_ProductBrandSize"));
            log.error("Product BrandSize on Minicart - " + web.getElementText("TillKassanProductBrandSize"));
            return false;
        }
    }

    public boolean isPriceCorrectInMiniCart() {
        BigDecimal productPriceOnPDP, productPriceOnMinicart, quantityOfProducts, price;

        log.info("ProductPrice_str => " + web.getElementText("ProductPrice"));
        log.info("ProductPrice_getDigit => " + Util.getDigitFromString(web.getElementText("ProductPrice")));
        productPriceOnPDP = new BigDecimal(Util.getDigitFromString(web.getElementText("ProductPrice")));

        log.info("TillKassanProductAmount_str => " + web.getElementText("TillKassanProductAmount"));
        log.info("TillKassanProductAmount_getDigit => " + Util.getDigitFromString(web.getElementText("TillKassanProductAmount")));
        productPriceOnMinicart = new BigDecimal(Util.getDigitFromString(web.getElementText("TillKassanProductAmount")));
        quantityOfProducts = new BigDecimal(web.getElement("TillKassanPopUp_QuantityOfProducts").getAttribute("value"));

        price = productPriceOnPDP.multiply(quantityOfProducts);

        log.info("productPriceOnPDP - " + productPriceOnPDP + "\n" +
                "productPriceOnMinicart - " + productPriceOnMinicart + "\n" +
                "quantityOfProducts - " + quantityOfProducts + "\n" +
                "price after calculation - " + price + "\n");

        if (productPriceOnMinicart.equals(price)) {
            log.info("ProductPrice shown correct");
            return true;
        } else {
            log.error("ProductPrice shown INCORRECT!\n");
            log.error("ProductPrice on PDP - " + productPriceOnPDP);
            log.error("ProductPrice on Minicart - " + productPriceOnMinicart);
            return false;
        }
    }

    public boolean isCurrencyCorrectInMiniCart() {
        web.waitForElementPresent("TillKassanCurrency");

        if (web.getElementText("ProductCurrency").equals(web.getElementText("TillKassanCurrency"))
                && web.getElementText("ProductCurrency").equals(web.getElementText("TillKassanTotalCurrency"))) {

            log.info("Product Currency shown correct");
            return true;
        } else {
            log.error("Product Currency shown INCORRECT!\n");
            log.error("Product Currency on PDP - " + web.getElementText("ProductCurrency"));
            log.error("Product Currency on Minicart - " + web.getElementText("TillKassanCurrency"));
            log.error("Product TotalCurrency on Minicart - " + web.getElementText("TillKassanCurrency"));
            return false;
        }
    }

    public boolean isTotalAmountCorrect_ForOneProduct_OnMiniCart() {
        BigDecimal productPriceOnPDP, quantityOfProducts, productTotalAmountOnMinicart, productTotalAmountMustBe;

        productPriceOnPDP = new BigDecimal(Util.getDigitFromString(web.getElementText("ProductPrice")));
        quantityOfProducts = new BigDecimal(web.getElement("TillKassanPopUp_QuantityOfProducts").getAttribute("value"));
        productTotalAmountOnMinicart = new BigDecimal(Util.getDigitFromString(web.getElementText("TillKassanProductAmount")));

        productTotalAmountMustBe = productPriceOnPDP.multiply(quantityOfProducts, new MathContext((web.getElementText("TillKassanTotalAmount").length() - 3)));

        log.info("productPriceOnPDP - " + productPriceOnPDP + "\n" +
                "quantityOfProducts - " + quantityOfProducts + "\n" +
                "productTotalAmountOnMinicart - " + productTotalAmountOnMinicart + "\n" +
                "productTotalAmountMustBe - " + productTotalAmountMustBe + "\n");

        if (productTotalAmountOnMinicart.equals(productTotalAmountMustBe)) {
            log.info("ProductPrice shown correct");
            return true;
        } else {
            log.error("ProductPrice shown INCORRECT!\n");
            log.error("productPriceOnPDP - " + productPriceOnPDP + "\n" +
                    "quantityOfProducts - " + quantityOfProducts + "\n" +
                    "productTotalAmountOnMinicart - " + productTotalAmountOnMinicart + "\n" +
                    "productTotalAmountMustBe - " + productTotalAmountMustBe + "\n");
            return false;
        }
    }

    public boolean isQuantityOfProductCorrectInMiniCart(String quantityOfProduct) {
        String popUp_QuantityOfProduct = web.getElement("TillKassanPopUp_QuantityOfProducts").getAttribute("value");

        if (popUp_QuantityOfProduct.equals(quantityOfProduct)) {
            log.info("QuantityOfProduct shown correct");
            return true;
        } else {
            log.error("QuantityOfProduct shown INCORRECT!\n");
            log.error("QuantityOfProduct on Minicart - " + popUp_QuantityOfProduct);
            log.error("QuantityOfProduct Expected - " + quantityOfProduct);
            return false;
        }
    }



    /**
     *    For multiple products
     */
    public void validationAddedItemsToMiniCart() {
        List<WebElement> quantitiesOfProductsBlocks = web.getElements("TillKassanProductsBlocks");
        log.info("Quantities of product block in the Basket - " + quantitiesOfProductsBlocks.size());

        web.waitForElementPresent("TillKassanProductsCurrencies");

        Assert.assertTrue(web.isAllElementsPresent("TillKassanProductsBlocks")
                && web.isAllElementsPresent("TillKassanProductsNames")
                && web.isAllElementsPresent("TillKassanProductsImages")
                && web.isAllElementsPresent("TillKassanProductsBrandSizes")
                && web.isAllElementsPresent("TillKassanProductsQuantities")
                && web.isAllElementsPresent("TillKassanProductsPrices")
                && web.isAllElementsPresent("TillKassanProductsCurrencies")
                && isTotalAmountCorrect_ForMultipleProducts_OnMiniCart(), "Products has been added to the cart INCORRECTLY!");

        log.warn("Verifications of the add products the to Basket have been successfully completed!\n");
    }

    public boolean isTotalAmountCorrect_ForMultipleProducts_OnMiniCart() {
        List<WebElement> productsPrices = new ArrayList<>();
        productsPrices.addAll(web.getElements("TillKassanProductsPrices"));

        double prices = 0;

        for (int i = 0; i < productsPrices.size(); i++) {
            prices +=  Util.getDigitFromString(productsPrices.get(i).getText());
        }

        double totalAmount = Util.getDigitFromString(web.getElementText("TillKassanTotalAmount"));

        if (prices == totalAmount) {
            log.warn("TotalAmountCorrect_ForMultipleProducts_OnMiniCart is correct!\n" +
                    "The price of all products - " + prices + "\n" +
                    "The total Amount - " + totalAmount);
            return true;
        } else {
            log.error("TotalAmountCorrect_ForMultipleProducts_OnMiniCart is INCORRECT!\n" +
                    "The price of all products - " + prices + "\n" +
                    "The total Amount - " + totalAmount + "\n");
            return false;
        }
    }



    /**
     * Minicart
     */
    public void switchToCheckoutPage() {
        openMiniCart();

        web.waitForElementToBeClickable("TillKassanPopUp_SwitchToCheckoutPage_Button");
        web.waitForElementPresent("TillKassanPopUp_SwitchToCheckoutPage_Button");
        web.clickButton("TillKassanPopUp_SwitchToCheckoutPage_Button");

        if (web.isElementPresent("CheckoutTitle")) {
            log.info("Correct switch to CheckoutPage");
        } else {
            log.error("INCORRECT switch to CheckoutPage!\n");
            Assert.fail("INCORRECT switch to CheckoutPage from mini card on PDP!");
        }
    }

    public void openMiniCart() {
        web.waitForElementToBeClickable("TillKassanPopUp_Link");
        web.waitForElementPresent("TillKassanPopUp_Link");
        web.clickLink("TillKassanPopUp_Link");
    }

    public void openMinicartAndClickAddToWishlist() {
        openMiniCart();
        web.waitForElementToBeClickable("TillKassanPopUp_AddToWishlistButton");
        web.waitForElementPresent("TillKassanPopUp_AddToWishlistButton");
        web.clickButton("TillKassanPopUp_AddToWishlistButton");
    }

    public void closeTheMinicart() {
        web.clickButton("TillKassanPopUp_CloseButton");

        web.waitForElementNotVisible("TillKassanPopUp_CloseButton");

        Assert.assertFalse(web.isElementPresent("TillKassanPopUp_CloseButton"), "Basket has been closed unsuccessfully!");
    }

    public void pressButtonToIncreaseTheProductOnTheMinicart() {
        web.waitForElementPresent("IncreaseNumberOfProductsButton");
        web.waitForElementToBeClickable("IncreaseNumberOfProductsButton");
        web.clickButton("IncreaseNumberOfProductsButton");
    }

    public void pressButtonToDecreaseTheProductOnTheMinicart() {
        web.waitForElementPresent("DecreaseNumberOfProductsButton");
        web.waitForElementToBeClickable("DecreaseNumberOfProductsButton");
        web.clickButton("DecreaseNumberOfProductsButton");
    }

    public void setFirstProductQuantityFieldOnTheMinicart(String value) {
        web.waitForElementPresent("TillKassanPopUp_QuantityOfFirstProduct_inputField");
        web.inputAndClickEnter("TillKassanPopUp_QuantityOfFirstProduct_inputField", value);
        web.clickLink("TillKassanPopUp_Title");     //to remove cursor from input field
    }

    public boolean isFabricSizeErrorPresent(String errorMessage) {
        if (web.isElementPresent("MeasuredFabric_inputFieldLabel")
                && web.getElementText("MeasuredFabric_inputFieldError").equals(errorMessage)) {
            log.info("MeasuredFabric_inputFieldError is correct");
            return true;
        } else {
            log.error("MeasuredFabric_inputFieldLabel is present - " + web.isElementPresent("MeasuredFabric_inputFieldLabel") + "\n" +
                    "MeasuredFabric_inputFieldError is error correct - " + web.getElementText("MeasuredFabric_inputFieldError").equals(errorMessage));
            return false;
        }
    }

}
