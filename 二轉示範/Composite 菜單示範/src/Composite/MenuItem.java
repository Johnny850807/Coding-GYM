package Composite;

public interface MenuItem extends Iterable<MenuItem>{
    String getType();
    String getName();
}
