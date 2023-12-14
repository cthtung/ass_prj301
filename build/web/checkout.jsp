
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Đơn hàng</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="components/navBarComponent.jsp" %>

        <!-- Product section-->
        <section class="py-5">

            <div class="container" style="min-height: 1000px">
                
                <h3>Thông tin khách hàng</h3>
                        <form action="checkout" method="POST">
                            <div class="mb-3">
                                <label for="name" class="form-label">Tên</label>
                                <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">SĐT</label>
                                <input type="text" class="form-control" id="phone" name="phone" aria-describedby="emailHelp">
                            </div>
                            <div class="mb-3">
                                <label for="address" class="form-label">Địa chỉ</label>
                                <input type="text" class="form-control" id="address" name="address" aria-describedby="emailHelp">
                            </div>
                            <div class="mb-3">
                                <label for="note" class="form-label">Ghi chú</label>
                                <textarea class="form-control" id="note" name="note" rows="3"></textarea>
                            </div>
                            <button type="submit" class="btn btn-success w-100">Thanh toán</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="components/footerComponent.jsp" %>
    </body>
</html>

