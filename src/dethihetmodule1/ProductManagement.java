package dethihetmodule1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagement implements Storable,Searchable {
    public ArrayList<Product> products;
    public String fileName;

    public ProductManagement(ArrayList<Product> products) {
        this.products = products;

    }

    public ProductManagement() {

    }

    @Override
    public void searchByName(String name) {
        List<Product> searchByName = products
                .stream()
                .filter(t -> name.equals(t.getName()))
                .collect(Collectors.toList());
        if (searchByName.isEmpty()) {
            System.out.println("Name not match");
        } else {
            searchByName.forEach(System.out::println);
        }
    }

    @Override
    public void searchById(Long id) {
        List<Product> searchById = products
                .stream()
                .filter(t -> id == t.getId())
                .collect(Collectors.toList());
        if (searchById.isEmpty()) {
            System.out.println("Id not match");
        } else searchById.forEach(System.out::println);

    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void remove(Long productId) {
        List<Product> removeById = products
                .stream()
                .filter(t -> productId == t.getId())
                .collect(Collectors.toList());
        if (removeById.isEmpty()) {
            System.out.println("Id not match");
        } else products.removeAll(removeById);
    }
}