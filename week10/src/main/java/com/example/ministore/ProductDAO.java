package com.example.ministore;
import java.sql.*;
public class ProductDAO {
    public void showAll() throws SQLException {
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("SELECT code,name,price,stock FROM products ORDER BY code"); ResultSet rs=ps.executeQuery()) {
            while(rs.next()) System.out.printf("%s | %s | %.2f | stock: %d%n",rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
        }
    }
    public void add(Product p) throws SQLException {
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("INSERT INTO products(code,name,price,stock) VALUES(?,?,?,?)")) {
            ps.setString(1,p.getCode());ps.setString(2,p.getName());ps.setDouble(3,p.getPrice());ps.setInt(4,p.getStock());ps.executeUpdate();
        }
    }
    public void search(String code) throws SQLException {
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("SELECT name,price,stock FROM products WHERE code=?")) {
            ps.setString(1,code);
            try(ResultSet rs=ps.executeQuery()) {
                if(rs.next()) System.out.printf("%s | %.2f | stock: %d%n",rs.getString(1),rs.getDouble(2),rs.getInt(3));
                else System.out.println("Product not found");
            }
        }
    }
    public boolean updatePrice(String code,double price) throws SQLException {
        if(price<0 || !Double.isFinite(price)) throw new IllegalArgumentException("Invalid price");
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("UPDATE products SET price=? WHERE code=?")) {
            ps.setDouble(1,price);ps.setString(2,code);return ps.executeUpdate()>0;
        }
    }
    public boolean delete(String code) throws SQLException {
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("DELETE FROM products WHERE code=?")) {
            ps.setString(1,code);return ps.executeUpdate()>0;
        }
    }
    // Instructor solution: atomic stock deduction, no negative quantity or overselling.
    public void sellProduct(String code,int qty) throws SQLException {
        if(qty<=0) {System.out.println("Quantity must be positive");return;}
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("UPDATE products SET stock=stock-? WHERE code=? AND stock>=?")) {
            ps.setInt(1,qty);ps.setString(2,code);ps.setInt(3,qty);
            if(ps.executeUpdate()>0) {System.out.println("Sale successful");return;}
        }
        try(Connection c=DBConnection.getConnection(); PreparedStatement ps=c.prepareStatement("SELECT stock FROM products WHERE code=?")) {
            ps.setString(1,code);
            try(ResultSet rs=ps.executeQuery()) {
                System.out.println(rs.next()?"Insufficient stock (available: "+rs.getInt(1)+")":"Product not found");
            }
        }
    }
    public void showLowStock(int limit) throws SQLException {
    try(Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT code,name,price,stock FROM products WHERE stock<=? ORDER BY stock,code")) {
        ps.setInt(1,limit);
        try(ResultSet rs=ps.executeQuery()) {
            boolean found=false;
            while(rs.next()) {
                found=true;
                System.out.printf("%s | %s | %.2f | stock: %d%n",rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
            }
            if(!found) System.out.println("No products with stock <= "+limit);
        }
    }
}
}
