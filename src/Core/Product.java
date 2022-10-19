package Core;

import java.util.ArrayList;
import java.util.List;

public class Product implements VisitableItem {
    public String id;
    private ArrayList<Trading> tradingList = new ArrayList<>();
    public Product(String id){this.id = id;}
    public List<Trading> getTradings(){ return tradingList;}

    public void addTrading(Trading trading) {
        tradingList.add(trading);
    }
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
