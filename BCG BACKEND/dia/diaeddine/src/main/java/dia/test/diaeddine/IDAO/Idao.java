package dia.test.diaeddine.IDAO;

import java.util.List;

public interface Idao<T> {
    void save(T o);

    void delete(T o);


    List<T> findAll();

    T findById(int id);
}
