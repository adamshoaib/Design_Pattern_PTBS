package Core;

import java.util.List;
import java.util.Map;

public class MeatProductMenu implements ProductMenu{
    @Override
    public void showMenu() {
        System.out.println("___ MeatProductMenu : Show menu Function ___");
        printMenuItems();
    }

    public void printMenuItems() {
        DataHandler dataHandler = new DataHandler();
        try {
            Map<String, List<String>> products = dataHandler.getLoginMappings("ProductInfo.txt");
            System.out.println("**** Menu: " + products.get("Meat") + " ****");
        }
        catch (Exception e) {
            System.out.println("OOPS .... Something went wrong while fetching productInfo List.");
        }
    }
    @Override
    public void showAddButton() {
        System.out.println("___ MeatProductMenu : Show Add button ___");
    }
    @Override
    public void showViewButton() {
        System.out.println("___ MeatProductMenu : Show View button ___");
    }
    @Override
    public void showRadioButton() {
        System.out.println("___ MeatProductMenu : Show Radio button ___");
    }
    @Override
    public void showLabels() {
        System.out.println("___ MeatProductMenu : Show Labels ___");
    }
    @Override
    public void showComboxes() {
        System.out.println("___ MeatProductMenu : showComboxes ___");
    }
}
