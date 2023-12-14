/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ADMIN
 */
public class CustomerDAO extends DBContext{
    public Connection con = null; //connect to sql
    public PreparedStatement ps = null; //ném câu lệnh query sang sql
    public ResultSet rs = null; //nhận kết quả trả về
    
    public Customer getAccount(String user, String pass){
        String query = "select * from customer\n"
                       + "where uID = ?";
        try{
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch(Exception e) {
            
        }
        return null;
    }
    
    public void insertCustomer(int ac_id, String name, String address, String phone){
        String query = "INSERT [dbo].[customer] ([account_id], [name], [email], [address], [phone]) VALUES (?, ?, null, ?, ?)";
        try {
            con = new DBContext().connection; //connect sql
            ps = con.prepareStatement(query);
            ps.setInt(1, ac_id);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    } 
}
