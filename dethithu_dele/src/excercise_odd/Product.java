package excercise_odd;


public class Product {
    private int id;
    private String name;
    private Double price;
    private String color;

    public Product(int id, String name, Double price, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
    }
    public Product(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product's id: " + id +
                " name: " + name +
                " price: " + price +
                " color: " + color;
    }


}
