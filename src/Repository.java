import java.util.*;

public interface Repository<T> {


    void add(T object);

    void remove(String id);

    T findById(String id);

    List<T> findAll();


}
