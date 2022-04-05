package lpnt.cg.service;

import java.util.List;

public interface IGeneralService<T> {

    List<T> findAll();

    T findById(long id);

    void remove(Long id);

    void save(T t);

}

