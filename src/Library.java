import java.util.ArrayList;
import java.util.*;
public class Library implements Repository<Book> {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    @Override
    public void add(Book object) {

    }

    @Override
    public void remove( String id) {

    }

    @Override
    public Book findById(String id) {
        return null;
    }


    @Override
    public List<Book> findAll() {
        return books;
    }
}
