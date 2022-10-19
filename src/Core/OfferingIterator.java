package Core;
public class OfferingIterator extends ListIterator<Offering> {
    OfferingIterator(OfferingList offeringList) {
        this.arrList = offeringList;
        currPos = 0;
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
    public Offering next() {
        if(currPos<arrList.size()) {
            int nextPos = currPos + 1;
            return arrList.get(nextPos);
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
