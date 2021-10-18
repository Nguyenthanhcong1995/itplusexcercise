package question1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Question2 {

    static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Read file to ArrayList");
        readFileToArrayList(bookList);
        System.out.println("Print book list and count book");
        showBookList();
        System.out.println("Arrange book list and print");
        arrangeBookList();
    }

    public static List<Book> readFileToArrayList(List<Book> bookList) throws FileNotFoundException {
        Reader readerFile = new FileReader("/home/congpv/Downloads/javaweb/Excercise_Modul1/book.txt");
        try (Scanner inputFile = new Scanner(readerFile)) {
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] data = line.split(";");
                int bookId = Integer.parseInt(data[0]);
                String bookName = data[1];
                String bookPublisher = data[2];
                Book book = new Book(bookId, bookName, bookPublisher);
                bookList.add(book);
            }
        }
        return bookList;
    }

    public static void showBookList() {
        System.out.println(bookList.size());
        bookList.forEach(System.out::println);
    }

    public static void arrangeBookList() {
        List<Book> arrange = bookList.stream()
                .sorted(Comparator.comparing(Book::getName))
                .collect(Collectors.toList());
        arrange.forEach(System.out::println);
    }
}
