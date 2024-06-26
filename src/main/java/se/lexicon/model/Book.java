package se.lexicon.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person currentOwner;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.currentOwner = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setCurrentOwner(Person currentOwner) {
        this.currentOwner = currentOwner;
        this.available = currentOwner == null;
    }

    public Person getCurrentOwner() {
        return currentOwner;
    }

    public String getBookInformation() {
        return "BookID: " + id +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nAvailable: " + available +
                "\nOwner: " + (currentOwner != null ? currentOwner.getFirstName() + " " + currentOwner.getLastName() : "None");
    }
}
