package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CartPage;
import page.HomePage;
import page.OrderModal;
import page.ProductPage;
import utils.BaseTest;

public class CartStepDef extends BaseTest {

    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);
    ProductPage productPage = new ProductPage(driver);
    OrderModal orderModal = new OrderModal(driver);

    @And("user adds item {string} to the cart")
    public void userAddsItemToTheCart(String productName) {
        homePage.clickProduct(productName);
        productPage.addProductToCart();
    }

    @Then("the item {string} should be present in the cart")
    public void theItemShouldBePresentInTheCart(String productName) {
        cartPage.openCartPage();
        cartPage.validateItemInCart(productName);
    }

    @And("user navigates to the cart page")
    public void userNavigatesToTheCartPage() {
        cartPage.openCartPage();
    }

    @And("delete all item in the cart")
    public void deleteAllItemInTheCart() {
        cartPage.deleteAllItem();
    }

    @When("user clicks the {string} button")
    public void userClicksButton(String buttonText) {
        cartPage.clickButton(buttonText);
    }

    @Then("Order form is open")
    public void orderFormIsOpen() {
        orderModal.validateIsOpen();
    }
}
