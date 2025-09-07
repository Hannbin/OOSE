import java.util.*;

class Product {
    String name;
    String category;
    double price;
    int quantity;

    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public void update(double newPrice, String newDesc) {
        this.price = newPrice;
        this.name = newDesc;
    }

    public double totalValue() {
        return price * quantity;
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }

    @Override
    public String toString() {
        return name + " - " + category + " - $" + price + " - SL: " + quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Áo", "Thời trang", 200, 10));
        products.add(new Product("Laptop", "Điện tử", 15000, 5));
        products.add(new Product("Giày", "Thời trang", 500, 20));

        System.out.println("Danh sách sản phẩm:");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nTổng giá trị tồn kho theo danh mục:");
        Map<String, Double> inventory = new HashMap<>();
        for (Product p : products) {
            inventory.put(p.category, inventory.getOrDefault(p.category, 0.0) + p.totalValue());
        }
        for (String c : inventory.keySet()) {
            System.out.println(c + ": " + inventory.get(c));
        }

        System.out.println("\nÁp dụng giảm giá 10% cho tất cả sản phẩm...");
        for (Product p : products) {
            p.applyDiscount(10);
        }
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nĐặt hàng sản phẩm Laptop (2 cái):");
        for (Product p : products) {
            if (p.name.equals("Laptop")) {
                int soLuong = 2;
                System.out.println("Tổng tiền = " + (p.price * soLuong));
            }
        }
    }
}
