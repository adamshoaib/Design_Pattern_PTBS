package Core;

import java.util.Iterator;

class OfferingList<Offering> extends java.util.ArrayList<Offering> {
    @Override
    public Iterator<Offering> iterator() {
        return (Iterator<Offering>) new OfferingIterator(this);
    }
}