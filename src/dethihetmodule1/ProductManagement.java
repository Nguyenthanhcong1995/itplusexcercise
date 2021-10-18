package dethihetmodule1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagement implements Storable,Searchable {
    public ArrayList<Product> productArrayList;
    public String fileName;

    public ProductManagement(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;

    }

    public ProductManagement() {

    }

    @Override
    public void searchByName(String name) {
        List<Product> searchByName = productArrayList
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
        List<Product> searchById = productArrayList
                .stream()
                .filter(t -> id == t.getId())
                .collect(Collectors.toList());
        if (searchById.isEmpty()) {
            System.out.println("Id not match");
        } else searchById.forEach(System.out::println);

    }

    @Override
    public void add(Product product) {
        productArrayList.add(product);
    }

    @Override
    public void remove(long productId) {
        List<Product> removeById = productArrayList
                .stream()
                .filter(t -> productId == t.getId())
                .collect(Collectors.toList());
        if (removeById.isEmpty()) {
            System.out.println("Id not match");
        } else productArrayList.removeAll(removeById);
    }
}