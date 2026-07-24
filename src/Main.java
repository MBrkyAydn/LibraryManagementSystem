import InputHelper.InputHelper;
import exception.*;
import model.Book;
import model.Member;

import java.io.IOException;
import java.util.Scanner;

// Exception sonrası porgram kapanıyor. Örnegin silenecek kitap bulunamadıgında. // kişiye verilen kitap listelemede gözukmuyor 0 ile çıkış yapılamıyor.
public class Main {
    public static void main(String[] args) {
        menu();

    }

    static Scanner input = new Scanner(System.in);
    static Library library = new Library();

    public static void menu() {
        int choice;

        while (true) {
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
            System.out.println("9- Find Member");
            System.out.println("0- Exit");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    try {
                        listBooks();
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    try {
                        findBook();
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        removeBook();
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    try {
                        addMember();
                    } catch (MemberAlreadyExist e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    try {
                        listMember();
                    } catch (MemberNotFound e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 7:
                    try {
                        borrowBook();
                    } catch (BookAlreadyBorrowedException | MemberNotFound | BookNotFoundException e) { // alreadybarrow çalışmıyort.
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        returnBook();
                    } catch (MemberNotFound | BookAlreadyExist e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 9:
                    try {
                        findMember();
                    } catch (MemberNotFound e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Bye");
                    System.exit(0);

                    break;
                default:
                    System.out.println("İnvalid İnput");

                    break;


            }
        }
    }

    public static void findMember() {
        String id = InputHelper.getValidString("Id");
        Member member = library.findMemberById(id);

        System.out.println(member);
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
        for (Book book : library.findAll()) {
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
        library.borrowBook(memberId, id);
        System.out.println("Book borrowed the Member " + memberId);


    }

    public static void returnBook() {
        String id = InputHelper.getValidString("Book Id: ");
        String memberId = InputHelper.getValidString("Member Id: ");
        library.returnBook(memberId, id);
        System.out.println("Book returned the Member " + memberId);

    }

    public static void findBook() {
        String id = InputHelper.getValidString("Book Id: ");
        Book book = library.findById(id);
        System.out.println("Book found the Member ");
        System.out.println(book);


    }

    public static void addMember() {
        String id = InputHelper.getValidString("Member Id: ");
        String name = InputHelper.getValidString("Member Name: ");
        String lastName = InputHelper.getValidString("Member Last Name: ");

        Member member = new Member(id, name, lastName);
        library.addMember(member);
        System.out.println("Member added the library" + name + " " + lastName);


    }

    public static void listMember() {
        library.listMember();

    }  // gösteriyor ama notfound da atıyor


}



