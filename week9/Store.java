package week9;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Store {
    private final ArrayList<Product> products = new ArrayList<>();
    public boolean addProduct(Product p){
        if(findProductByCode(p.getCode())!=null) return false;
        products.add(p); return true;
    }
    public Product findProductByCode(String code){
        for(Product p:products) if(p.getCode().equals(code)) return p;
        return null;
    }
    public void showAllProducts(){ for(Product p:products) p.showInfo(); }
    public boolean sellProduct(String code,int qty){
        Product p=findProductByCode(code);
        return p!=null && p.sell(qty);
    }
    public void saveToFile(String filename) throws IOException {
        try(BufferedWriter out=Files.newBufferedWriter(Path.of(filename),StandardCharsets.UTF_8)){
            for(Product p:products){
                out.write(p.getCode()+","+p.getName()+","+p.getPrice()+","+p.getStock());
                out.newLine();
            }
        }
    }
    public void loadFromFile(String filename) throws IOException {
        ArrayList<Product> loaded=new ArrayList<>();
        try(BufferedReader in=Files.newBufferedReader(Path.of(filename),StandardCharsets.UTF_8)){
            String line; int row=0;
            while((line=in.readLine())!=null){
                row++;
                if(line.isBlank()) continue;
                String[] a=line.split(",",-1);
                if(a.length!=4) throw new IOException("Invalid column count at line "+row);
                try{
                    Product p=new Product(a[0].trim(),a[1].trim(),
                            Double.parseDouble(a[2].trim()),Integer.parseInt(a[3].trim()));
                    for(Product old:loaded)
                        if(old.getCode().equals(p.getCode())) throw new IOException("Duplicate code at line "+row);
                    loaded.add(p);
                }catch(IllegalArgumentException e){
                    throw new IOException("Invalid data at line "+row,e);
                }
            }
        }
        products.clear();
        products.addAll(loaded);
    }
}
