package pages;
// This class use inheritance

public class GooglePage extends BasePage {

    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchTextField = "//input[@title='Buscar']";

    public GooglePage () {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria) {
        write(searchTextField, criteria);

    }
}
