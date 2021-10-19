package bookdata;

import excercise_odd.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public interface FileInputOutput {
    String path = "/home/congpv/Downloads/javaweb/dethithu_dele/src/bookdata/product.txt";

    static String readFileByScanner(String path) throws FileNotFoundException {
        Reader readerFile = new FileReader(path);
        try (Scanner inputFile = new Scanner(readerFile)) {
            StringBuilder outputString = new StringBuilder();
            while (inputFile.hasNext()) {
                String line = inputFile.nextLine();
                outputString.append("\n" + line);
            }
            return outputString.toString();
        }

    }

    default void readFileToConsole() {
        try {
            String fileData = FileInputOutput.readFileByScanner(path);
            System.out.println("File Data: " + fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not exit");
        }
    }

    default List<Product> saveFileToArrayList(List<Product> productFile) throws FileNotFoundException {
        Reader readerFile = new FileReader(path);
        try (Scanner inputFile = new Scanner(readerFile)) {
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] data = line.split(";");
                int productId = Integer.parseInt(data[0]);
                String productName = data[1];
                Double productPrice = Double.parseDouble(data[2]);
                String productColor = data[3];
                Product product = new Product(productId, productName, productPrice, productColor);
                productFile.add(product);

            }
        }
        return productFile;

    }

    default void arrangeByPrice(List<Product> productList) {
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
        Collections.reverse(productList);
        productList.forEach(System.out::println);
    }

    default void deleteById(int id, List<Product> products) {
        List<Product> deleteProductById = products
                .stream()
                .filter(t -> id == t.getId())
                .collect(Collectors.toList());
        if (deleteProductById.isEmpty()){
            System.out.println("id not match");
        }else products.removeAll(deleteProductById);
    }
}

