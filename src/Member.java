import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name, lastName;
   private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name, String lastName, List<Book> borrowedBooks) {
        this.name = name;
        this.lastName = lastName;
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
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

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


}
