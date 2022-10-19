package Core;

import java.util.ArrayList;
import java.util.Iterator;

abstract class ListIterator<T> implements Iterator<T> {
    protected ArrayList<T> arrList;
    protected int currPos;
    abstract void moveToHead();
}
