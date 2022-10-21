package Core;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassProductList<Product> extends ArrayList<Product> {
    // add all the product list to the array list
    public ClassProductList(List<Product> productList) {
        this.addAll(productList);
    }
    // func without parameters for inital initilization
    public  ClassProductList() {}
    // to iterate over the products
    @Override
    public Iterator<Product> iterator() {
        return (Iterator<Product>) new ProductIterator(this);
    }
}
