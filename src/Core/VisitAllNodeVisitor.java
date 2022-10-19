package Core;

import java.util.Iterator;

public class VisitAllNodeVisitor extends NodeVisitor {

    @Override
    public void visit(Facade facade) {
        System.out.println("**** Visiting Facade Pattern ****");
        System.out.println("**** Iterating all products in Facade using iterator pattern ****");
        ProductIterator itr = (ProductIterator) facade.getAllProducts().iterator();
        while(itr.hasNext()) {
            itr.next().accept(this);
        }
   }

    @Override
    public void visit(Product product) {
        System.out.println("****"+(product.id)+" : Product Visiting .... ****");
        Iterator<Trading> itr = product.getTradings().iterator();
        while(itr.hasNext()) {
            itr.next().accept(this);
        }
    }

    @Override
    public void visit(Trading trading) {
        System.out.println("**** Visit Trading Class ****");
    }
}
