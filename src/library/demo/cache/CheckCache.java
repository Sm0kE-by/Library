package library.demo.cache;

import java.util.List;
import java.util.Map;

public interface CheckCache<E> {
    default boolean checkCache(Map<Integer, List<E>> map, int i) {
        return map.containsKey(i);
    }
}
