
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

public class Main {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> searchBook();
                case 4 -> issueBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 0 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findBook(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            System.out.println(
                "ID: " + b.id +
                " | Title: " + b.title +
                " | Author: " + b.author +
                " | Status: " + (b.issued ? "Issued" : "Available")
            );
        }
    }

    static Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    static void searchBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book b = findBook(id);

        if (b != null) {
            System.out.println("Found: " + b.title + " by " + b.author);
        } else {
            System.out.println("Book not found!");
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
        } else if (b.issued) {
            System.out.println("Book is already issued!");
        } else {
            b.issued = true;
            System.out.println("Book issued successfully!");
        }
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
        } else if (!b.issued) {
            System.out.println("Book was not issued!");
        } else {
            b.issued = false;
            System.out.println("Book returned successfully!");
        }
    }

    static void deleteBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
        } else if (b.issued) {
            System.out.println("Return the book before deleting it.");
        } else {
            books.remove(b);
            System.out.println("Book deleted successfully!");
        }
    }
}
