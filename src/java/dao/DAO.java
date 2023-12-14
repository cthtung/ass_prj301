/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.*;
import context.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
//load data from db
public class DAO {

    public Connection con = null; //connect to sql
    public PreparedStatement ps = null; //ném câu lệnh query sang sql
    public ResultSet rs = null; //nhận kết quả trả về

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public List<Product> getAllProductByCate(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID= ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public Product getProductById(String id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from\n"
                + " product where id= ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where [name] like ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public void updateProduct(Product x) {
        String query = "update product\n"
                + "set [name]=?, image=?, price=?, title = ?, description = ?, cateID =? where [id]=?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, x.getName());
            ps.setString(2, x.getImage());
            ps.setDouble(3, x.getPrice());
            ps.setString(4, x.getTitle());
            ps.setString(5, x.getDescription());
            ps.setInt(6, x.getCateID());
            ps.setInt(7, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void deleteProduct(String id) {
        String query = "DELETE FROM product\n"
                + "WHERE [id] = ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {

        }
    }

    public void insertProduct(String name, String image, double price, String title, String description, int cateID) {
        String query = "INSERT [dbo].[product] ([name], [image], [price], [title], [description], [cateID]) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cateID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public Category getCategoryById(String id) {
        String query = "select * from Category where cid = ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {

        }

        return null;
    }


    
    public void updateCategory(String id, String name) {
        String query = "update Category\n"
                + "set cname= ? where cid=?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void insertCategory(String name) {
        String query = "INSERT [dbo].[Category] ([cname]) VALUES (?)";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    public void insertCategory() {
        String query = "INSERT [dbo].[Category] ([cname]) VALUES (xyz)";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Category checkCateExist(String name) {
        String query = "select * from Category where cname = ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public Account login(String user, String pass) {
        String query = "select * from Account\n"
                + "where [user] = ? \n"
                + "and pass = ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from Account\n"
                + "where [user] = ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public void signup(String user, String pass) {
        String query = "INSERT [dbo].[Account] ([user], [pass], [isSell], [isAdmin], [active]) VALUES (?, ?, 0, 0, 0)";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public Account getAccountById(String id) {
        String query = "select * from\n"
                + " Account where [uID]= ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public void updateAccountById(Account x) {
        String query = "update Account\n"
                + "set [user]=?, pass=?, isSell=?, isAdmin=? where uID=?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, x.getUser());
            ps.setString(2, x.getPass());
            ps.setInt(3, x.getIsSell());
            ps.setInt(4, x.getIsAdmin());
            ps.setInt(5, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void updatePass(String pass, String user) {
        String query = "update Account\n"
                + "set pass=? where [user]=?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void deleteAccount(String id) {
        String query = "DELETE FROM Account\n"
                + "WHERE [uID] = ?";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {

        }
    }

    public int countProduct() {
        String query = "select count(*) from product";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "order by id\n"
                + "offset ? rows fetch next 8 row only;";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getAllProducts(String xSortColName, String xSortType) {
        List<Product> t = new ArrayList<>();
        String xSql = "select * from product order by " + xSortColName + " " + xSortType;
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Product x;
            while (rs.next()) {
                x = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Product> getAllProductsByCate(String cate, String xSortColName, String xSortType) {
        List<Product> t = new ArrayList<>();
        String xSql = "select * from product where cateID =" + cate + " "  + "order by " + xSortColName + " " + xSortType;
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Product x;
            while (rs.next()) {
                x = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public static void main(String[] args) {
    }
}
