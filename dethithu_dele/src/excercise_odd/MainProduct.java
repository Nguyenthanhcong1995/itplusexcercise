package excercise_odd;

import bookdata.FileInputOutput;
import exception.IdDuplicate;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;

public class MainProduct implements Activities, Search, FileInputOutput, Input {

    static MainProduct mainProduct = new MainProduct();
    List<Product> products = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        mainProduct.menu();
    }

    public void menu() throws FileNotFoundException {
        System.out.println("Welcome to product management system: ");
        menu:
        while (true) {
            System.out.println("1 to add new product" +
                    "\n2 to edit product's information" +
                    "\n3 to search product by name " +
                    "\n4 to search product by price" +
                    "\n5 to show product's list" +
                    "\n6 to work with file" +
                    "\n7 to exit");
            String type = inputString(input, "Enter your command: ");
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
                    searchByName();
                    break;
                }
                case "4": {
                    searchByPri();
                    break;
                }
                case "5": {
                    show();
                    break;
                }
                case "6": {
                    question2();
                    break;
                }

                case "7": {
                    break menu;
                }
                default:
                    System.out.println("Invalid command");
            }
        }
    }


    @Override
    public void add() {
        System.out.println("Entry new product");
        int id = inputScanInt(input, "Enter product's id");
        String name = inputString(input, "Enter product's name");
        Double price = inputScanDub(input, "Enter product's price");
        String color = inputString(input, "Enter product's color");
        Iterator<Product> iter = products.iterator();
        deleteExitedId(id, iter);
        Product product = new Product(id, name, price, color);
        products.add(product);
    }

    private void deleteExitedId(int id, Iterator<Product> iter) {
        while (iter.hasNext()) {
            try {
                if (iter.next().getId() == id) {
                    iter.remove();
                    throw new IdDuplicate();
                }
            } catch (IdDuplicate e) {
                System.err.println("Id has already exited ");
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Edit product's information");
        int id = inputScanInt(input, "Enter product's id");
        List<Product> edit = new ArrayList<>();
        for (Product product : products) {

            if (product.getId() == id) {
                product.setColor(inputString(input, "Enter new color"));
                product.setPrice(inputScanDub(input, "Enter new price"));
                product.setName(inputString(input, "Enter new name"));
                edit.add(product);
            }
        }
        if (edit.size() == 0) {
            System.err.println("Id not match");
        }
    }

    @Override
    public void show() {
      products.forEach(System.out::println);
        }
    @Override
    public void searchByName() {
        System.out.println("Search product by name");
        String name = inputString(input, "Enter product's name");
        List<Product> searchByName = products
                .stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
        if (searchByName.isEmpty()){
            System.out.println("No such name");
        }else searchByName.forEach(System.out::println);

        /*for (Product product : products) {
            if (product.getName().contains(name)) {
                searchByName.add(product);
            }
        }
        try {
            if (searchByName.size() > 0) {
                searchByName.forEach(System.out::println);
            } else {
                throw new NotFound();
            }
        } catch (Exception e) {
            System.err.println("Name not match");
        }
*/
    }

    @Override
    public void searchByPri() {
        System.out.println("Search product by price");
        Double price = inputScanDub(input, "Enter product's price");
        List<Product> searchByPrice = products
                .stream()
                .filter(product -> product.getPrice()==price)
                .collect(Collectors.toList());
        if(searchByPrice.isEmpty()){
            System.out.println("No such price");
        }else searchByPrice.forEach(System.out::println);
        /*for (Product product : products) {

            if (product.getPrice().equals(price)) {
                searchByPrice.add(product);
            }
        }
        try {
            if (searchByPrice.size() > 0) {
                searchByPrice.forEach(System.out::println);
            } else {
                throw new NotFound();
            }
        } catch (NotFound e) {
            System.out.println("Price not match");
        }*/
    }

    public void question2() throws FileNotFoundException {
        System.out.println("File handling");
        List<Product>productFile=new ArrayList<>();
        subMenu:
        while (true){
            System.out.println("a to read file "+
                    "\nb to save file to ArrayList"+
                    "\nc to count and print product's list"+
                    "\nd to arrange product by price and print product's list"+
                    "\ne to delete product by id"+
                    "\nf to exit question2");
            String command=inputString(input,"Enter your command");
            switch (command){
                case "a":{
                    readFileToConsole();
                    break;
                }
                case "b":{
                    saveFileToArrayList(productFile);
                    break;
                }
                case "c":{
                    System.out.println("The highest price is: "+productFile
                            .stream()
                            .collect(maxBy(Comparator.comparing(Product::getPrice))));
                    System.out.println("Total product's number: "+productFile.
                            stream()
                            .collect(counting()));
                    productFile.forEach(System.out::println);
                    break;
                }
                case "d":{
                    arrangeByPrice(productFile);
                    break;
                }
                case "e":{
                    deleteById(inputScanInt(input,"Enter product's id you want to remove: "),productFile);
                    break;
                }
                case "f":{
                    break subMenu;
                }
                default:
                    System.out.println("Invalid command");
            }
        }
    }

}
