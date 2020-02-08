package Composite;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractCompositeMenuItem extends AbstractMenuItem {
    protected List<MenuItem> children = Collections.checkedList(
            new LinkedList<>(), MenuItem.class);

    public AbstractCompositeMenuItem(String type, String name) {
        super(type, name);
    }

    public AbstractCompositeMenuItem addItem(MenuItem subItem) {
        children.add(subItem);
        return this;
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new CompositeIterator();
    }

    private class CompositeIterator implements Iterator<MenuItem> {
        private boolean hasIteratedSelf = false;
        private int curIndex = 0;
        private Iterator<MenuItem> curIterator;

        public CompositeIterator() {
            if(!children.isEmpty()) {
                curIterator = children.get(0).iterator();
            }
        }

        @Override
        public boolean hasNext() {
            if (!hasIteratedSelf) {
                return true;
            }
            if (children.isEmpty()) {
                return false;
            }
            if (curIterator.hasNext()) {
                return true;
            }
            curIndex++;
            if (curIndex >= children.size()) {
                return false;
            }
            curIterator = children.get(curIndex).iterator();
            return curIterator.hasNext();
        }

        @Override
        public MenuItem next() {
            if (!hasIteratedSelf) {
                hasIteratedSelf = true;
                return AbstractCompositeMenuItem.this;
            }
            return curIterator.next();
        }
    }
}
