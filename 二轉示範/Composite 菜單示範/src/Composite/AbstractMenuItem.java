package Composite;

import java.util.Iterator;

public abstract class AbstractMenuItem implements MenuItem {
    private String type;
    private String name;

    public AbstractMenuItem(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n", type, name);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new Iterator<MenuItem>() {
            boolean hasNext = true;
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public MenuItem next() {
                hasNext = false;
                return AbstractMenuItem.this;
            }
        };
    }
}
