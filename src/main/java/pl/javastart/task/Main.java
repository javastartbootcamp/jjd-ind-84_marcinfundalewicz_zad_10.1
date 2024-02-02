package pl.javastart.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Book[] books = new Book[3];
        System.out.println("Podaj informacje o trzech unikalnych ksiazkach");
        int counter = 0;
        int counter2 = 0;
        while (counter < books.length) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj tytul");
            String title = scanner.nextLine();
            System.out.println("Podaj ilosc stron");
            int pages = scanner.nextInt();
            Book book = new Book(title, pages);
            books[counter] = book;
            for (int i = 0; i <= counter; i++) {
                if (title.equals(books[i].getTitle())) {
                    counter2++;
                }
            }
            if (counter2 >= 3) {
                System.out.println("Duplikat");
                counter2 = 0;
                continue;
            }
            counter++;
        }
        for (int i = 0; i < books.length; i++) {
            System.out.println("Ksiazka: " + books[i].getTitle() + ", liczba stron: " + books[i].getPages());
        }
    }
}