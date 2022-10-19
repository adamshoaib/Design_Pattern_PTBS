package Core;

public class Buyer extends Person{

    public Buyer(String userName) {
        super(userName,0);
    }

    @Override
    void showMenu() {
        System.out.println("**** Inside Buyer Class || Bridge Pattern Used ****");

        productMenu.showMenu();
        productMenu.showComboxes();
        productMenu.showAddButton();
        productMenu.showLabels();
        productMenu.showRadioButton();
        productMenu.showViewButton();
    }

    @Override
    public ProductMenu createProductMenu(int type) {
        System.out.println("**** Inside Buyer Class || Factory Pattern Used ****");
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
