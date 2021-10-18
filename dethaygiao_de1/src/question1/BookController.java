package question1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class BookController extends Input implements Activity, Search {
    Set<Book> books = new HashSet<>();

    public void menu() {
        System.out.println("Welcome to book management application");

        menu:
        while (true) {
            System.out.println("Enter your choice:" +
                    "\n1 to entry new book" +
                    "\n2 for edit book's information" +
                    "\n3 to remove book" +
                    "\n4 to search book by name" +
                    "\n5 to show book's list" +
                    "\n6 to exit");
            System.out.println("Enter your choice: ");
            String type = inputString();
            switch (type) {
                case "1": {
                    add();
                    break;
                }
                case "2": {
                    edit();
                    break;
                }
                case "3": {
                    remove();
                    break;
                }
                case "4": {
                    searchByName();
                    break;
                }
                case "5": {
                    System.out.println(books
                            .stream()
                            .collect(counting()));
                    books.forEach(System.out::println);
                    break;
                }
                case "6": {
                    break menu;
                }
                default:
                    System.err.println("Invalid choice");
            }
        }
    }


    @Override
    public void add() {
        System.out.println("Adding book");
        System.out.println("Enter book's id");
        int bookId = inputScannerInt();
        System.out.println("Enter book's name");
        String bookName = inputString();
        System.out.println("Enter book's publisher:");
        String bookPub = inputString();

        Book book = new Book(bookId, bookName, bookPub);
        books.add(book);
    }

    @Override
    public void edit() {
        System.out.println("Edit book");
        System.out.println("Enter book's id");
        int idEdit = inputScannerInt();
        /*for (Book book : books) {
            if (idEdit == book.getId()) {
                System.out.println("Enter new name");
                book.setName(inputString());
                System.out.println("Enter new publisher");
                book.setPublisher(inputString());
                return;
            }
        }
            System.err.println("Id not match! ");*/
        books
                .stream()
                .filter(book -> book.getId() == idEdit)
                .findFirst()
                .ifPresent(book -> {
                    System.out.println("Enter new name: ");
                    book.setName(inputString());
                    System.out.println("Enter new publisher");
                    book.setPublisher(inputString());
                });
    }


    @Override
    public void remove() {
        System.out.println("Remove book");
        System.out.println("Enter book's Id");
        int idRemove = inputScannerInt();
        /*for (Book book : books) {
            if (book.getId() == idRemove) {
                books.remove(book);
                System.out.println("Remove successful");
                return;
            }
        }
        System.err.println("Id not match");*/
        List<Book> bookRemove =
        books
                .stream()
                .filter(book -> book.getId() == idRemove)
                .collect(Collectors.toList());
        if (bookRemove.isEmpty()){
            System.out.println("Id not match");
        }else {
            System.out.println("Delete successful");
            books.removeAll(bookRemove);
        }
    }

    @Override
    public void searchByName() {
        System.out.println("Search by name");
        System.out.println("Enter book's name");
        String bookName = inputString();
        Set<Book> search = books
                .stream()
                .filter(book -> book.getName().contains(bookName))
                .collect(Collectors.toCollection(HashSet::new));
        /*for (Book book : books) {
            if (book.getName().toLowerCase().contains(bookName)) {
                search.add(book);
            }
        }*/

        if (search.isEmpty()) {
            System.out.println("Name not match");
        } else {
            search.forEach(System.out::println);
        }

    }

}
