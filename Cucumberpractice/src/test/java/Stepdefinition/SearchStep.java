package Stepdefinition;

import Impelmentation.Product;
import Impelmentation.Search;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {
	Product product;
	Search search;
	@Given("I have a search field on amazon page")
	public void i_have_a_search_field_on_amazon_page() {
	System.out.println("step1:i am on search page");  
	}

	@When("I search for a product with name {string} and price {int}")
	public void i_search_for_a_product_with_name_and_price(String productname, Integer price) {
		System.out.println("step2: search the product name"+productname+" price:  " +price);
		product =new Product(productname,price);
	}

	@Then("Product with name {string} should be displayed")
	public void product_with_name_should_be_displayed(String productname) {
		System.out.println("step3  product"+ productname +"is displayed");
	search =new Search();
	Search.disaplayProduct(product);
	
	}


	
	
}
