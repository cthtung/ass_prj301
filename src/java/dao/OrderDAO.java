/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends DBContext {
    
    public Connection con = null; //connect to sql
    public PreparedStatement ps = null; //ném câu lệnh query sang sql
    public ResultSet rs = null; //nhận kết quả trả về

    public void addOrder(Account a, Cart cart, String note) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        String query = "INSERT [dbo].[Orders] ([account_id], [totalPrice], [note], [create_date]) VALUES (?, ?, ?, ?)";
        try {
            //add to order
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setInt(1, a.getId());
            ps.setDouble(2, cart.getTotalMoney());
            ps.setString(3, note);
            ps.setString(4, date);
            ps.executeUpdate();

            //get id of order
            String queryId = "select top 1 id from [Orders] order by id desc";
            ps = con.prepareStatement(queryId);
            rs = ps.executeQuery();

            //add vào orderdetail
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item item : cart.getItems()) {
                    String queryDe = "INSERT [dbo].[OrderDetail] ([order_id], [productName], [productImage], [productPrice], [quantity]) VALUES (?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(queryDe);
                    ps.setInt(1, oid);
                    ps.setString(2, item.getProduct().getName());
                    ps.setString(3, item.getProduct().getImage());
                    ps.setDouble(4, item.getPrice());
                    ps.setInt(5, item.getQuantity());
                    ps.executeUpdate();
                }
            }
            
        } catch (Exception e) {
            
        }
        
    }
    
    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String query = "select * from Orders";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        List<Order> list = dao.getAllOrder();
        for (Order order : list) {
            System.out.println(order.toString());
        }
    }
}
