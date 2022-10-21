package Core;

import java.util.Date;

public class Trading implements VisitableItem{
    public Trading() {}
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
