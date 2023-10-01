package fa.training.main;


import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.utils.IsbnValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LibraryManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        MagazineService magazineService = new MagazineService();

        while (true) {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.println("7. Quit");
            System.out.print("Please choose a function: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    if (!IsbnValidator.isValidIsbn(isbn)) {
                        System.out.println("Invalid ISBN format.");
                        break;
                    }

                    System.out.print("Enter publication year: ");
                    int pubYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();

                    System.out.print("Enter publication date: ");
                    String pubDate = scanner.nextLine();

                    System.out.print("Enter author (comma-separated): ");
                    String authorsInput = scanner.nextLine();
                    String[] authorArray = authorsInput.split(",");
                    Set<String> authors = new HashSet<>(Arrays.asList(authorArray));

                    System.out.print("Enter publication place: ");
                    String publicationPlace = scanner.nextLine();

                    Book book = new Book(pubYear, publisher, pubDate, isbn, authors, publicationPlace);
                    bookService.addBook(book);
                    break;

                case 2:
                    // Add a magazine
                    System.out.print("Enter publication year: ");
                    int magPubYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter publisher: ");
                    String magPublisher = scanner.nextLine();

                    System.out.print("Enter publication date: ");
                    String magPubDate = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String magAuthor = scanner.nextLine();

                    System.out.print("Enter volume: ");
                    int magVolume = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter edition: ");
                    int magEdition = scanner.nextInt();
                    scanner.nextLine();

                    Magazine magazine = new Magazine(magPubYear, magPublisher, magPubDate, magAuthor, magVolume, magEdition);
                    magazineService.addMagazine(magazine);
                    break;

                case 3:

                    bookService.displayBooks();
                    magazineService.displayMagazines();
                    break;

                case 4:

                    System.out.print("Enter ISBN of the book: ");
                    String bookIsbn = scanner.nextLine();

                    System.out.print("Enter author to add: ");
                    String newAuthor = scanner.nextLine();

                    if (bookService.addAuthorToBook(bookIsbn, newAuthor)) {
                        System.out.println("Author added successfully.");
                    } else {
                        System.out.println("Author already exists.");
                    }
                    break;

                case 5:

                    magazineService.displayTopMagazinesByVolume(10);
                    break;

                case 6:

                    System.out.println("Search options:");
                    System.out.println("1. Search by ISBN");
                    System.out.println("2. Search by author");
                    System.out.println("3. Search by publisher");
                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter search query: ");
                    String searchQuery = scanner.nextLine();

                    switch (searchChoice) {
                        case 1:
                            bookService.searchBookByIsbn(searchQuery);
                            break;
                        case 2:
                            bookService.searchBookByAuthor(searchQuery);
                            break;
                        case 3:
                            bookService.searchBookByPublisher(searchQuery);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 7:

                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid function.");
                    break;
            }
        }
    }
}
