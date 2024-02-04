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
            if (isUnique(book, books, booksCounter) != 0) {
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
        Book book = new Book(title, pages);
        return book;
    }

    private static int isUnique(Book book, Book[] books, int booksCounter) {
        int innerMethodCounter = 0;
        for (int i = 0; i <= booksCounter; i++) {
            if (book.getTitle().equals(books[i].getTitle())) {
                innerMethodCounter++;
            }
            if (innerMethodCounter >= 2) {
                System.out.println("Duplikat");
                return 0;
            }
        }
        return 1;
    }
}