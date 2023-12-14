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
        <title>detail</title>
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
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${listP.getImage()}" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">${listP.getId()}</div>
                        <h1 class="display-5 fw-bolder">${listP.getName()}</h1>
                        <div class="fs-5 mb-5">
                            <span>$${listP.getPrice()}</span>
                        </div>
                        <p class="lead">${listP.getDescription()}</p>
                        <div class="d-flex">
                            <a href="addToCart?id=${listP.getId()}" class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Thêm vào giỏ
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="components/footerComponent.jsp" %>
    </body>
</html>

