package Core;

public abstract class NodeVisitor {
    public abstract void visit(Facade facade);
    public abstract void visit(Product product);
    public abstract void visit(Trading trading);
}
