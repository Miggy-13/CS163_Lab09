public class Product {
    String name;
    int sku;
    double price;
    double weight;
    int destination;
    int quantity;

    public Product() {
        name = "";
        sku = -1;
        price = -1;
        weight = -1;
        destination = -1;
        quantity = -1;
    }

    public Product(String name, int sku, double price, double weight, int destination, int quantity) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.weight = weight;
        this.destination = destination;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getDestination() {
        return destination;
    }

    public String toString() {
        String str = quantity + " " + name + ", weighing " + weight + " kilograms: To be shipped to " + destination + ", SKU: " + sku;  
        return str;
    }
}
