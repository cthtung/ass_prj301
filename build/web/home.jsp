
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
        <title>THE COMPUTER</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-" href="assets/thenoob.ico" />
        <!-- Bootstrap icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>

    <body style="background-color: #cccccc">
        <%@include file="components/navBarComponent.jsp" %>
        <!-- Header-->
        <header>
            <div>
                <img style="width: 100%;" height="600px" src="img/5999741.jpg"/>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row"> 
                    <div class="col-md-3 mb-5">
                        <ul class="list-group category_block">
                                <c:forEach items="${listC}" var="C">
                                <li class="list-group-item text-white ${tag == C.cid? "active":""}"><a href="category?cid=${C.cid}">${C.cname}</a></li>
                                </c:forEach>
                        </ul>
                        <ul class="list-group category_block">

                        </ul>
                    </div>                
                    <div class="col-md-9">
                        <h2 align="center" style="color:grey;">Product in store</h2>
                        <div class="row gx-4 gx-lg-4 row-cols-2 row-cols-md-4">
                            <c:if test="${listP.size() == 0}">
                                <div class="col mb-5">
                                    <h4 style="margin-top: 20px; color: grey;">Not have product in store</h4>
                                </div>
                            </c:if>
                            <c:forEach items="${listP}" var="o">
                                <div class="col mb-5">
                                    
                                    <div class="card h-100">
                                        <!-- Product image-->
                                        <a href="detail?productId=${o.id}">
                                            <img
                                                class="card-img-top"
                                                src="${o.image}"
                                                alt="..."
                                                style="height: 200px;"/>
                                        </a>
                                        <!-- Product details-->

                                        <div class="card-body p-4">
                                            <div class="text-center">
                                                <!-- Product name-->
                                                <h5 class="fw-bolder">${o.name}</h5>
                                                <!-- Product reviews-->
                                                <div class="d-flex justify-content-center small text-warning mb-2" >
                                                    <div>${o.title}</div>
                                                </div>
                                                <!-- Product price-->
                                                <div>$${o.price}</div>
                                            </div>
                                        </div>

                                        <!-- Product actions-->
                                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                            <div class="text-center">
                                                <c:if test="${sessionScope.currAccount != null}">
                                                    <a class="btn btn-outline-dark mt-auto" href="addToCart?id=${o.id}"
                                                       >Thêm vào giỏ</a>
                                                </c:if>
                                                <c:if test="${sessionScope.currAccount == null}">
                                                    <a class="btn btn-outline-dark mt-auto" href="login.jsp"
                                                       >Thêm vào giỏ</a>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${listP==null || listP.size()==0}">
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-12" align="center">
                            <c:forEach begin="1" end="${endPage}" var="i">
                                <button><a href="countPro?index=${i}" align="center">${i}</a></button>
                                </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>

        </section>
        <%@include file="components/footerComponent.jsp" %>
    </body>
</html>
