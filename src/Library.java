import exception.BookNotFoundException;
import exception.MemberAlreadyExist;

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

    public Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
throw new MemberAlreadyExist(id+" Member already exist ");
    }

    public void addMember(Member member) {

    }

    @Override
    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }

        }
        throw new BookNotFoundException("Book with id " + id + " not found");
    }


    @Override
    public List<Book> findAll() {
        return books;
    }


}
