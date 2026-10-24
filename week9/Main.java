package week9;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Store store=new Store();
        store.addProduct(new Product("P001","Keyboard",850,10));
        store.addProduct(new Product("P002","Mouse",350,15));
        store.addProduct(new Product("P003","Monitor",4500,5));
        store.addProduct(new Product("P004","Webcam",1200,8));
        store.addProduct(new Product("P005","Speaker",990,6));
        System.out.println("Before sale:");
        store.showAllProducts();
        System.out.println("Sell P002 x 3: "+store.sellProduct("P002",3));
        try {
            store.saveToFile("products.csv");
            Store reopened=new Store();
            reopened.loadFromFile("products.csv");
            System.out.println("After loading:");
            reopened.showAllProducts();
        } catch(IOException e) {
            System.out.println("File error: "+e.getMessage());
        }
    }
}
