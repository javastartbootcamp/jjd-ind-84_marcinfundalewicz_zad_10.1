package pl.javastart.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int booksCounter = 0;
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[3];
        System.out.println("Podaj informacje o trzech unikalnych ksiazkach");
        while (booksCounter < books.length) {
            Book book = createBook(scanner);
            if (isUnique(book, books, booksCounter)) {
                books[booksCounter] = book;
                booksCounter++;
            }
        }
        for (Book book : books) {
            System.out.println("Ksiazka: " + book.getTitle() + ", liczba stron: " + book.getPages());
        }
    }

    private static Book createBook(Scanner scanner) {
        System.out.println("Podaj tytul");
        String title = scanner.nextLine();
        System.out.println("Podaj ilosc stron");
        int pages = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, pages);
        return book;
    }

    private static boolean isUnique(Book book, Book[] books, int booksCounter) {
        int innerMethodCounter = 0;
        for (int i = 0; i < booksCounter; i++) {
            if (book.equals(books[i])) {
                innerMethodCounter++;
            }
        }
        if (innerMethodCounter >= 1) {
            System.out.println("Duplikat");
            return false;
        }
        return true;
    }
}