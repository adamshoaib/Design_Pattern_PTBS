package Core;
public class OfferingIterator extends ListIterator<Offering> {
    OfferingIterator(OfferingList offeringList) {
        // OfferingIterator constructor
        this.arrList = offeringList;
        currPos = 0;
    }

    @Override
    void moveToHead() {
        // Not doing anything Just a print statement
        System.out.println("moveToHead --------------->");
    }

    @Override
    public boolean hasNext() {
        // Not doing anything Just a print statement
        System.out.println("Inside next Offering Iterator");
        return true;
    }

    @Override
    public Offering next() {
        // Not doing anything Just a print statement
        System.out.println("Inside next Offering Iterator");
        return null;
    }

    @Override
    public void remove() {
        // Not doing anything Just a print statement
        System.out.println("Inside remove Offering Iterator");
    }
}
