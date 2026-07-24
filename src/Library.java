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
            throw new BookAlreadyBorrowedException(" Book already borrowed");

        }
        book.setAvailable(false);
        member.borrowBook(book);
    }

    public void addMember(Member member) {
        for (Member m : members) {
            if (m.getId().equals(member.getId())) {
                throw new MemberAlreadyExist(member.getId() + " Member already exist ");
            }
        }
        members.add(member);
    }

    public void returnBook(String memberId, String bookId) {
        Book book = findById(bookId);
        Member member = findMemberById(memberId);
        if (book.isAvailable()) {
            throw new BookAlreadyExist(book.getId() + " Book already exist");

        }
        book.setAvailable(true);
        member.getBorrowedBooks().remove(book);

    }

    public Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        throw new MemberNotFound("Member with id " + id + " not found");
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

    public void listMember() {
        if (members.isEmpty()) {
            throw new MemberNotFound("Member not found");
        }
        for (Member member : members) {
            System.out.println(member);
        }
    }

    @Override
    public List<Book> findAll() {
        if (books.isEmpty()) {
            throw new BookNotFoundException("Books not found");
        }

        return books;
    }

    public void listAvailableBooks() {

        books.stream().filter(Book::isAvailable).forEach(System.out::println);
    }

    public void listBookTitle() {
        books.stream().map(Book::getTitle).forEach(System.out::println);
    }

    public void sortBook() {
        books.stream().sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);

    }

    public void countBooks() {
        long count = books.stream().count();
        System.out.println(count);
    }

    public boolean anyMatch(String title) {
        return books.stream()
                .anyMatch(book -> book.getTitle().equalsIgnoreCase(title));

    }

    public Book findFirst() {
       return   books.stream().filter(Book::isAvailable).findFirst().orElse(null);
    }

    public Book searchTitle(String title) {
       return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElseThrow(() ->
               new BookNotFoundException("Book not found"));
    }
}
