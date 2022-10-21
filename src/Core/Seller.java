package Core;

public class Seller extends Person {

    public Seller(String userName) {
        super(userName,1);
    }

    @Override
    void showMenu() {
        System.out.println("**** Inside Seller Class || Bridge Pattern Used ****");
        if(productMenu == null) {
            System.out.println("Please first create product menu by choosing option 1");
        } else {
            displayAllPrintStatements();
        }
    }

    void displayAllPrintStatements() {
        productMenu.showMenu();
        productMenu.showComboxes();
        productMenu.showAddButton();
        productMenu.showLabels();
        productMenu.showRadioButton();
        productMenu.showViewButton();
    }

    @Override
    public ProductMenu createProductMenu(int type) {
        System.out.println("**** Inside Seller Class || Factory Pattern Used ****");
       return assignProductMenu(type);
    }

    public ProductMenu assignProductMenu(int type) {
        if(type == 0) {
            productMenu = new MeatProductMenu();
            System.out.println("**** Meat Product Menu initialized to the seller ****");
        } else {
            productMenu = new ProduceProductMenu();
            System.out.println("**** Produce Product Menu initialized to the seller ****");
        }
        return productMenu;
    }
}
