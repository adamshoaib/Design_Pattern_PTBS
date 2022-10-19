package Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassProductList<Product> extends ArrayList<Product> {
    public ClassProductList(List<Product> productList)
    {
        this.addAll(productList);
    }
    @Override
    public Iterator<Product> iterator() {
        return (Iterator<Product>) new ProductIterator(this);
    }
}
