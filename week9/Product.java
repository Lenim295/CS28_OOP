package week9;
public class Product {
    private String code, name;
    private double price;
    private int stock;
    public Product(String code, String name, double price, int stock) {
        if (code == null || code.isBlank() || name == null || name.isBlank()
                || price < 0 || stock < 0) throw new IllegalArgumentException("Invalid product");
        this.code=code; this.name=name; this.price=price; this.stock=stock;
    }
    public String getCode(){ return code; }
    public String getName(){ return name; }
    public double getPrice(){ return price; }
    public int getStock(){ return stock; }
    public boolean sell(int qty){ if(qty<=0 || qty>stock) return false; stock-=qty; return true; }
    public void showInfo(){ System.out.printf("%s | %s | %.2f | Stock: %d%n",code,name,price,stock); }
}
