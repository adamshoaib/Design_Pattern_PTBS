package Core;

import java.util.Date;

public class Trading implements VisitableItem{

    // todo : adding deadline
    public Trading(Date endDate) {
        this.endDate = endDate;
    }
    public Date endDate = null;
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
