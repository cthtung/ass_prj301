<%-- 
    Document   : cart
    Created on : Oct 30, 2023, 7:40:10 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cart</title>
        <link rel="stylesheet" href="css_cart/style.css">
        <link rel="stylesheet" href="css_cart/bootstrap.css">
        <link rel="stylesheet" href="css_cart/bootstrap.min.css">
    </head>
    <body>
        <div class="container px-3 my-5 clearfix">
            <!-- Shopping cart table -->
            <div class="card" style="width: 95%;">
                <div class="card-header">
                    <h2>Shopping Cart</h2>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered m-0">
                            <thead>
                                <tr>
                                    <!-- Set columns width -->
                                    <th class="text-center py-3 px-4" style="min-width: 400px;">Product Name &amp; Details</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Price</th>
                                    <th class="text-center py-3 px-4" style="width: 120px;">Quantity</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Total</th>
                                    <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.listCart}" var="o">
                                    <tr>
                                        <td class="p-4">
                                            <div class="media align-items-center">
                                                <img src="${o.getProduct().getImage()}" class="d-block ui-w-40 ui-bordered mr-4" alt="">
                                                <div class="media-body">
                                                    <a href="#" class="d-block text-dark">${o.getProduct().getName()}</a>
                                                    <small>
                                                        <span class="ui-product-color ui-product-color-sm align-text-bottom" style="background:#e81e2c;"></span> &nbsp;
                                                        <span class="text-muted">CateID: ${o.getProduct().getCateID()}</span>
                                                    </small>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="text-right font-weight-semibold align-middle p-4">$${o.getProduct().getPrice()}</td>
                                        <td class="align-middle p-4">
                                            <button style="width: 22px;"><a href="process?num=-1&id=${o.getProduct().getId()}">-</a></button>
                                            <input type="text" name="num" value=${o.getQuantity()} readonly style="width: 50px; text-align: center;"/>
                                            <button style="width: 22px;"><a href="process?num=1&id=${o.getProduct().getId()}">+</a></button>
                                        </td>
                                        <td class="text-right font-weight-semibold align-middle p-4">${o.getQuantity() * o.getPrice()}</td>
                                        <td class="text-center align-middle px-0">
                                            <form action="process" method="post">
                                                <input type="hidden" name="id" value="${o.getProduct().getId()}">
                                                <input type="submit" value="x">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- / Shopping cart table -->

                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="d-flex">
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Total price: </label>
                                <div class="text-large"><strong>${cart.getTotalMoney()}</strong></div>
                            </div>
                        </div>
                    </div>

                    <div class="float-right">
                        <button type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3"><a href="countPro">Back to shopping</a></button>
                        <button type="button" class="btn btn-lg btn-primary mt-2"><a style="color:white;" href="checkout.jsp">Checkout</a></button>
                    </div>

                </div>
            </div>
        </div>
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/Jquery.js"></script>
    </body>
</html>
