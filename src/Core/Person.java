package Core;

import java.util.List;

public abstract class Person {
    Integer type;
    String userName;
    private ClassProductList productsAdded;
    public Person(String userName, Integer type) {
        this.userName = userName; this.type = type;
    }
    ProductMenu productMenu;
    private ClassProductList productListAdded;
    abstract void showMenu();
    public void addProduct(List<Product> prodList) {
        if(productsAdded == null) {
            productsAdded = new ClassProductList(prodList);
        } else {
            productsAdded.addAll(prodList);
        }
    }
    public abstract ProductMenu createProductMenu(int type);
    public ClassProductList getListOfProductsAdded() {
        return productListAdded;
    }

}
