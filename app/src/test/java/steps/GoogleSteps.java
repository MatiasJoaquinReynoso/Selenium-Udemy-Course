package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.GooglePage;
// Assertions will be here too

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        google.enterSearchCriteria("Wikipedia");
    }

    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResults(){
        Assert.assertEquals("Wikipedia", google.firstResult());
    }
}

// The assert for boolean elements its 'Assert.assertTrue / False'