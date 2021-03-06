package vlm.db;

import java.util.List;

public interface ValuesTable<T, V> extends DerivedTable {
    List<V> get(DbKey dbKey);

    void insert(T t, List<V> values);

    @Override
    void rollback(int height);

    @Override
    void truncate();
}
