import java.util.ArrayList;

public class GenericRepository<T, U> {
    ArrayList<T> list = new ArrayList<T>();
    U someVar;
    public int count() {
        return list.size();
    }

    public void add(T t) {
        list.add(t);
    }

    public T getFirst() {
        return list.get(0);
    }

}
