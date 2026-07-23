public class Main {
    public static void main(String[] args) {
Library library = new Library();
Book b1 = new Book("1","1","1",1);
Book b2 = new Book("2","1","1",1);
library.add(b1);
library.add(b2);

        System.out.println(library.findAll());

    }
}
