package week10.src.main.java.com.example.ministore;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);ProductDAO dao=new ProductDAO();
        while(true) {
            System.out.println("\n1 Show  2 Add  3 Search  4 Update price  5 Delete  6 Sell 7 Low stock 0 Exit");
            System.out.print("Choice: ");String choice=sc.nextLine().trim();
            try {
                switch(choice) {
                    case "1" -> dao.showAll();
                    case "2" -> {System.out.print("Code: ");String code=sc.nextLine();System.out.print("Name: ");String name=sc.nextLine();System.out.print("Price: ");double price=Double.parseDouble(sc.nextLine());System.out.print("Stock: ");int stock=Integer.parseInt(sc.nextLine());if(price<0||!Double.isFinite(price)||stock<0){System.out.println("Invalid price/stock");break;}dao.add(new Product(code,name,price,stock));System.out.println("Added");}
                    case "3" -> {System.out.print("Code: ");dao.search(sc.nextLine());}
                    case "4" -> {System.out.print("Code: ");String code=sc.nextLine();System.out.print("New price: ");double price=Double.parseDouble(sc.nextLine());System.out.println(dao.updatePrice(code,price)?"Updated":"Product not found");}
                    case "5" -> {System.out.print("Code: ");System.out.println(dao.delete(sc.nextLine())?"Deleted":"Product not found");}
                    case "6" -> {System.out.print("Code: ");String code=sc.nextLine();System.out.print("Quantity: ");int qty=Integer.parseInt(sc.nextLine());dao.sellProduct(code,qty);}
                    case "7" -> dao.showLowStock(5);
                    case "0" -> {System.out.println("Bye");return;}
                    default -> System.out.println("Invalid menu");
                }
            } catch(SQLException | IllegalArgumentException ex) {System.out.println("Error: "+ex.getMessage());}
        }
    }
}
