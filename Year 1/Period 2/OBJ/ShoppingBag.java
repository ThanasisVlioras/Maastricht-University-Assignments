import java.util.ArrayList;

interface Item {
    public String getName();
    public double getPrice();
}

class Product implements Item {
    private String name;
    private double price;
    private String bioInfo;

    public Product(String name, double price, String bioInfo) {
        this.name = name;
        this.price = price;
        this.bioInfo = bioInfo;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public String getBioInfo() {
        return bioInfo;
    }
    
}

public class ShoppingBag {
    private ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public int totalPriceForProduct(String productName) {
       return products.stream().filter(product -> product.getName().equals(productName)).mapToDouble(product -> product.getPrice()).sum();
    }
}