public interface SimpleQueue<T> {
    void addElement(T value);

    T removeFirstElement() throws Exception;

    T removeLastElement() throws Exception;

    T getFirstElement() throws Exception;

    T getLastElement() throws Exception;

    int count();

    boolean isEmpty();
}