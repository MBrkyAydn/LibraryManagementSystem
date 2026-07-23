import java.util.ArrayList;
import java.util.*;

public class Library implements Repository<Book> {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    @Override
    public void add(Book object) {
        books.add(object);

    }

    @Override
    public void remove(String id) {
    Book book = findById(id);
    books.remove(book);
    }

    @Override
    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }

        }
        return null;
    }


    @Override
    public List<Book> findAll() {
        return books;
    }


}
