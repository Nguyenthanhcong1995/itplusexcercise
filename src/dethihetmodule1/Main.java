package dethihetmodule1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class Main {
    public static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        question1();
        question2();
    }

    public static void question1() {
        ProductManagement productManagement = new ProductManagement(productList);

        Product product1 = new Product(1001, "pencil", "a1", 3);
        Product product2 = new Product(1002, "book", "a2", 5);
        Product product3 = new Product(1003, "phone", "a3", 8);
        Product product4 = new Product(1005, "shoes", "a4", 2);
        Product product5 = new Product(1005, "lamb", "a5", 9);
        Product product6 = new Product(1006, "lamb", "a5", 9);


        productManagement.add(product1);
        productManagement.add(product2);
        productManagement.add(product3);
        productManagement.add(product4);
        productManagement.add(product5);
        productManagement.add(product6);


        productList.forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        Set<Product> setPro = new HashSet<>(productList);
        setPro.forEach(System.out::println);
        System.out.println("Search by name: ");
        productManagement.searchByName("pencil");

        System.out.println("Search by id");
        productManagement.searchById(1005L);

        System.out.println("Remove by id");
        productManagement.remove(1002);
    }

    public static void question2() throws FileNotFoundException {
        ArrayList<Product> productList = new ArrayList<>();
        loadFileToArrayList(productList);
        System.out.println("Arrange product by name");
        productList.sort(Comparator.comparing(Product::getName));
        productList.forEach(System.out::println);

    }

    static List<Product> loadFileToArrayList(ArrayList<Product> productList) throws FileNotFoundException {
        String filePath = "/home/congpv/Downloads/n1008/product.txt";
        Reader readerFile = new FileReader(filePath);
        try (Scanner inputFile = new Scanner(readerFile)) {
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] data = line.split(";");
                long productId = Long.parseLong(data[0]);
                String productName = data[1];
                String productCategory = data[2];
                Double productQuantity = Double.parseDouble(data[3]);
                Product product = new Product(productId, productName, productCategory, productQuantity);

                productList.add(product);

            }
        }
        return productList;

    }
}
