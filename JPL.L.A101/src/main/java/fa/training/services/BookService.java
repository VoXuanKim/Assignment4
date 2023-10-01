package fa.training.services;

import fa.training.entities.Book;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            System.out.println("List of Books:");
            for (Book book : books) {
                book.display();
                System.out.println("---------------");
            }
        }
    }


    public boolean addAuthorToBook(String isbn, String author) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                Set<String> authors = book.getAuthors();
                if (!authors.contains(author)) {
                    authors.add(author);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.display();
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    public void searchBookByAuthor(String author) {
        System.out.println("Books by author " + author + ":");
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                book.display();
            }
        }
    }

    public void searchBookByPublisher(String publisher) {
        System.out.println("Books by publisher " + publisher + ":");
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                book.display();
            }
        }
    }


}
