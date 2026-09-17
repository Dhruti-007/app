abstract class Product {
    protected String productId;
    protected String name;
    protected double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayDetails() {
        System.out.println("ID: " + productId + " | Name: " + name +
                " | Price: " + price + " | Discount: " + calculateDiscount() +
                " | Fabstract class Product {inal Price: " + getFinalPrice());
    }
}

class Electronics extends Product {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }
}

class Clothing extends Product {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20; // 20% discount
    }
}

class Books extends Product {
    public Books(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }
}

public class ProductDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("E101", "Laptop", 50000),
            new Clothing("C101", "Jacket", 2000),
            new Books("B101", "Java Programming", 800)
        };

        for (Product p : products) {
            p.displayDetails(); // polymorphic call
        }
    }
}