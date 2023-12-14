
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation-->
<script>
    function login() {
        window.location.href = "login.jsp";
    }
    function logout() {
        window.location.href = "logout";

    }
</script>
<nav class="navbar navbar-expand-lg navbar-light bg-secondary">
    <div class="container px-4 px-lg-5">
        <a href="countPro"><img src="img/data-science.png" style="width: 80px;"></a>
        <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
            >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <c:if test="${sessionScope.currAccount.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link active text-white" aria-current="page" href="managerAc">Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-white" aria-current="page" href="managerCa">Category</a>
                    </li>
                    
                </c:if>
                <c:if test="${sessionScope.currAccount.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link active text-white" aria-current="page" href="addPro">Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-white" aria-current="page" href="bill">Manager bill</a>
                    </li>
                </c:if>
            </ul>
            <form action="search" class="d-flex mx-auto" method="post">
                <input
                    value="${key}"
                    class="form-control me-2"
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                    name="txt"
                    />
                <button class="btn btn-success" type="submit">
                    Tìm kiếm
                </button>
            </form>
            <div class="d-flex my-2">
                <a class="btn btn-dark" href="cart.jsp">
                    <i class="bi-cart-fill me-1"></i>
                    Giỏ hàng
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${size}</span>
                </a>
            </div>

            <c:choose>
                <c:when test="${sessionScope.currAccount == null}">
                    <button class="btn btn-primary ms-lg-2" onclick="login()">Đăng nhập</button>
                </c:when>

                <c:otherwise>
                    <button class="btn btn-success ms-lg-2" onclick="logout()">Đăng xuất</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
