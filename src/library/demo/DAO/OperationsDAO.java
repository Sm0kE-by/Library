package library.demo.DAO;

import java.util.List;
import java.util.Map;

public abstract class OperationsDAO<K, T> {
    ConnectionDataBase connectionDataBase = new ConnectionDataBase();

    public abstract void view(Map<K, List<T>> map);

    public abstract void search();

    public abstract void change();

    public abstract void delete();

    public abstract void add();

}
