package Core;

public interface VisitableItem {
    void accept(NodeVisitor visitor);
}
