import InputHelper.InputHelper;
import model.Book;
import model.Member;

import java.util.Scanner;
// Exception sonrası porgram kapanıyor. Örnegin silenecek kitap bulunamadıgında. // kişiye verilen kitap listelemede gözukmuyor 0 ile çıkış yapılamıyor.
public class Main {
    public static void main(String[] args) {
        while (true) { menu();} // Düzeltilecek.

    }

    static Scanner input = new Scanner(System.in);
    static Library library = new Library();

    public static void menu() {
        System.out.println("========= Library Management =========");
        System.out.println("1- Add Book");
        System.out.println("2- List Books");
        System.out.println("3- Find Book");
        System.out.println("4- Remove Book");
        System.out.println("-*-* Member Operations-*-*");
        System.out.println("5- Add Member");
        System.out.println("6- List Members");
        System.out.println("7- Borrow Book");
        System.out.println("8- Return Book");
        System.out.println("0- Exit");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                listBooks();
                break;
            case 3:findBook();
                break;
            case 4:removeBook();
                break;
            case 5:addMember();
                break;
            case 6:listMember();
                break;
            case 7:borrowBook();
                break;
            case 8:returnBook();
                break;
            case 0:
                break;
            default:
                System.out.println("İnvalid İnput");
                System.exit(0);
                break;


        }

    }

    public static void addBook() {
        String id = InputHelper.getValidString("Book Id: ");
        String title = InputHelper.getValidString("Title: ");
        String author = InputHelper.getValidString("Author: ");
        int page = InputHelper.getValidInt("Page Count: ");
        Book book = new Book(id, title, author, page);
        System.out.println("Book added the library");
        library.add(book);


    }

    public static void listBooks() {
        for (Book book : library.books) {
            System.out.println(book);

        }
    }
    public static void removeBook() {
        String id = InputHelper.getValidString("Book Id: ");
        library.remove(id);
        System.out.println("Book removed the library");

    }
    public static void borrowBook() {
        String id = InputHelper.getValidString("Book Id: ");
        String memberId = InputHelper.getValidString("Member Id: ");
        library.borrowBook(id, memberId);
        System.out.println("Book borrowed the Member "+memberId);
    }
    public static void returnBook() {
        String id = InputHelper.getValidString("Book Id: ");
        String memberId = InputHelper.getValidString("Member Id: ");
        library.returnBook(memberId, id);
        System.out.println("Book returned the Member "+memberId);

    }
    public static void findBook() {
        String id = InputHelper.getValidString("Book Id: ");
        Book book = library.findById(id);
        System.out.println("Book found the Member ");
        System.out.println(book);


    }
public static void addMember() {
        String id = InputHelper.getValidString("Member Id: ");
        String name=  InputHelper.getValidString("Member Name: ");
        String lastName= InputHelper.getValidString("Member Last Name: ");

    Member member = new Member(id, name, lastName);
    library.addMember(member);
    System.out.println("Member added the library"+name+" "+lastName);


}
    public static void listMember() {
        for (Member member : library.members) {

            System.out.println(member);
        }
    }


}



