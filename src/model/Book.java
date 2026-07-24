package model;

public class Book {
    private String id, title, author;
    private int pageCount;
    private boolean available;

    public Book(String id, String title, String author, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.available = true;
    }

    @Override
    public String toString() {
        return """
            -------------------------
            ID         : %s
            Title      : %s
            Author     : %s
            Page Count : %d
            Available  : %s
            -------------------------
            """.formatted(id, title, author, pageCount, available);
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public boolean isAvailable() {
        return available;
    }
}

