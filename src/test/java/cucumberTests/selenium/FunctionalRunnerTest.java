package cucumberTests.selenium;

import cucumber.api.CucumberOptions;


@CucumberOptions(
		//glue = "src/test/java/cucumberTests/selenium/glue/*Definitions",
		monochrome = true,
		plugin = {"pretty", "html:target/report/cucumber-report", "json:target/report/jsonReport/cucumber-report.json"},
		features = {"src/test/resources/features/"}
		//,
		//tags = {"@AreTestProductsAvailable?, @MainPage, @Login, @Registration, @RegistrationInCheckout, @ErrorPage, @Search, @ProductLineup,  @PDP, @Size, @Color, @Image, @Mini_cart, @WishlistFromPDP, @WishlistFromBasket, @WishlistFromCheckoutPage, @KontoFlow, @CODFlow, @FakturaFlow, @CreditCardFlow"}
		//tags = {"@Checkout-"}
		//tags = {"@Test"}
)
//TODO Size - delete comments T8,11,12
public class FunctionalRunnerTest extends Fixture {

}
