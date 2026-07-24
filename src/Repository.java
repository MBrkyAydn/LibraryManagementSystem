import java.util.*;

public interface Repository<T> {


    void add(T object); //Çünkü eklemek için nesneyi dışarıdan göndermen gerekir.

    void remove(String id);

    T findById(String id); // Çünkü aramak için elimizde nesne yok.Yani nesneyi sen göndermiyorsun, metod senin yerine buluyor..

    List<T> findAll(); // Çünkü bir tane değil, birden fazla nesne dönecek."Hepsini bana getir."

}
