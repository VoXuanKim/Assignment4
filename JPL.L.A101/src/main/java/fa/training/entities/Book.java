package fa.training.entities;

import java.util.Set;

public class Book extends Publication {
    private String isbn;
    private Set<String> authors;
    private String publicationPlace;

    public Book(int publicationYear, String publisher, String publicationDate, String isbn,
                Set<String> authors, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.authors = authors;
        this.publicationPlace = publicationPlace;
    }

    @Override
    public void display() {
        System.out.println("Book ISBN: " + isbn);
        System.out.println("Authors: " + authors);
        System.out.println("Publication Place: " + publicationPlace);
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Publication Date: " + getPublicationDate());
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }
}
