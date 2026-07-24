import exception.*;
import model.Book;
import model.Member;

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

    public void borrowBook(String memberId, String bookId) {
        Book book = findById(bookId);
        Member member = findMemberById(memberId);
        if (!book.isAvailable()) {
            throw new BookAlreadyBorrowedException("model.Book already borrowed");

        }
        book.setAvailable(false);
        member.borrowBook(book);
    }

    public void addMember(Member member) {
        for (Member m : members) {
            if (m.getId().equals(member.getId())) {
                throw new MemberAlreadyExist(member.getId() + " model.Member already exist ");
            }
        }
        members.add(member);
    }

    public void returnBook(String memberId, String bookId) {
        Book book = findById(bookId);
        Member member = findMemberById(memberId);
        if (book.isAvailable()) { throw new BookAlreadyExist(book.getId() + " model.Book already exist");

        }  book.setAvailable(true);
        member.getBorrowedBooks().remove(book);

    }

    public Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        throw new MemberNotFound("model.Member with id " + id + " not found");
    }

    @Override
    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }

        }
        throw new BookNotFoundException("model.Book with id " + id + " not found");
    }


    @Override
    public List<Book> findAll() {
        return books;
    }


}
