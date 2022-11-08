package library.demo.cache;

import java.util.List;
import java.util.Map;

public interface OperationsCache<N extends Number, T> {
    public void view(Map<N, List<T>> map);

    public void search();

    public void change();

    public void delete();

    public void add();
}
