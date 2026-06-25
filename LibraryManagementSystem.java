package LibraryManagementSystem;

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
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.print("\n1.Add 2.View 3.Issue 4.Return 5.Exit");
            int choice = sc.nextInt();

            if (choice == 1) add();
            else if (choice == 2) view();
            else if (choice == 3) issue();
            else if (choice == 4) ret();
            else break;
        }
    }

    static void add() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.print("Added");
    }

    static void view() {
        for (Book b : books) {
            String status = b.issued ? "Issued" : "Available";
            System.out.print(b.id + " | " + b.title + " | " + b.author + " | " + status);
        }
    }

    static void issue() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                b.issued = true;
                System.out.print("Issued");
                return;
            }
        }
        System.out.print("Not found");
    }

    static void ret() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                b.issued = false;
                System.out.print("Returned");
                return;
            }
        }
        System.out.print("Not found");
    }
}