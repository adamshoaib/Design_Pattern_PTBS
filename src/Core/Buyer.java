package Core;

public class Buyer extends Person{

    public Buyer(String userName) {
        super(userName,0);
    }

    // display menu to the user
    // if meu is not initiliased then show error to select option 1 to initiliaze.
    @Override
    void showMenu() {
        System.out.println("**** Inside Buyer Class || Bridge Pattern Used ****");
        if(productMenu == null) {
            System.out.println("Please first create product menu by choosing option 1");
        } else {
            displayAllPrintStatements();
        }
    }

    // Display all the methods of product menu
    void displayAllPrintStatements() {
        productMenu.showMenu();
        productMenu.showComboxes();
        productMenu.showAddButton();
        productMenu.showLabels();
        productMenu.showRadioButton();
        productMenu.showViewButton();
    }

    // assign product menu to the menu category.
    @Override
    public ProductMenu createProductMenu(int type) {
        System.out.println("**** Inside Buyer Class || Factory Pattern Used ****");
        return assignProductMenu(type);
    }

    // based on the category of the food initiliase the product menu
    public ProductMenu assignProductMenu(int type) {
        if(type == 0) {
            productMenu = new MeatProductMenu();
            System.out.println("**** Meat Product Menu initialized to the buyer ****");
        }
        else {
            productMenu = new ProduceProductMenu();
            System.out.println("**** Produce Product Menu initialized to the buyer ****");
        }
        return productMenu;
    }
}
