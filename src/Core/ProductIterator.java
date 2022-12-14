package Core;

public class ProductIterator extends ListIterator<Product> {

    public ProductIterator(ClassProductList productList) {
        this.arrList = productList;
        currPos = -1;
    }

    @Override
    void moveToHead() {
        currPos = 0;
    }

    @Override
    public boolean hasNext() {
        return (currPos < ( arrList.size() -1 ));
    }

    @Override
    public Product next() {
        if(currPos<arrList.size()) {
            return arrList.get(++currPos);
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        if(currPos<arrList.size()) {
            arrList.remove(currPos);
        }
    }
}
