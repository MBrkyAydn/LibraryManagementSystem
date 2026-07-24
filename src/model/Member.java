package model;

import java.util.ArrayList;
import java.util.List;


public class Member {
    private String name, lastName;
   private List<Book> borrowedBooks = new ArrayList<>();
String id;
    public Member(String name, String lastName,String id) {

        this.name = name;
        this.lastName = lastName;
        this.id= id;
        this.borrowedBooks = new ArrayList<>();
    }
public void borrowBook(Book book) {
        borrowedBooks.add(book);
}

    @Override
    public String toString() {
        return """
            -------------------------
            ID         : %s
            Name      : %s
            Last Name     : %s
            Borrowed Book : %s
            -------------------------
            """.formatted(id, name,lastName ,borrowedBooks);

    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


}
