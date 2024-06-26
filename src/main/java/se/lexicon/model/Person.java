package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private List<Book> borrowedBooks;

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void loanBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setCurrentOwner(this);
        } else {
            System.out.println("Book is not available for loan.");
        }
    }

    public void returnBook(Book book) {
        if (book.getCurrentOwner() == this) {
            borrowedBooks.remove(book);
            book.setCurrentOwner(null);
        } else {
            System.out.println("This book is not loaned by you.");
        }
    }

    public String getPersonInformation() {
        return "PersonID: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nLoaned books count: " + borrowedBooks.size();
    }

    public void getBookLoanInformation() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books loaned by this person.");
        } else {
            System.out.println("Books loaned by " + firstName + " " + lastName + ":");
            for (Book book : borrowedBooks) {
                System.out.println(book.getBookInformation());
            }
        }
    }
}
