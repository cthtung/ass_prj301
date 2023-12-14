/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Bill {
    private String orderID;
    private String cusName;
    private String createDate;
    private String address;
    private String phone;
    private double totalMoney;

    public Bill() {
    }

    public Bill(String orderID, String cusName, String createDate, String address, String phone, double totalMoney) {
        this.orderID = orderID;
        this.cusName = cusName;
        this.createDate = createDate;
        this.address = address;
        this.phone = phone;
        this.totalMoney = totalMoney;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Bill{" + "orderID=" + orderID + ", cusName=" + cusName + ", createDate=" + createDate + ", address=" + address + ", phone=" + phone + ", totalMoney=" + totalMoney + '}';
    }
    
    
}
