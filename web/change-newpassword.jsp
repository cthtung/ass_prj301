<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!--Author: DPV-->
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Đổi mật khẩu</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/q-icon.png" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />

        
    </head>

    <body>
        
        <section class="vh-100" style="background-color: #eee;">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-12 col-xl-11">
                        <div class="card text-black" style="border-radius: 5px;">
                            <div class="card-body p-md-5">
                                <div class="row justify-content-center">
                                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                        <p class="h3 mb-3 font-weight-normal" style="text-align: center">Đổi mật khẩu</p>
                                        
                                        <form class="mx-1 mx-md-4" action="editPa" method="post">
                                            
                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <label class="form-label" for="form3Example1c">Tài khoản</label>
                                                    <input type="text" id="form3Example1c" class="form-control" required name="user"/>
                                                </div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <label class="form-label" for="form3Example1c">Mật khẩu</label>
                                                    <input type="password" id="form3Example1c" class="form-control" required name="pass"/>
                                                </div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <label class="form-label" for="form3Example1c">Mật khẩu mới</label>
                                                    <input type="password" id="form3Example1c" class="form-control" required name="newPass"/>
                                                </div>
                                            </div>

                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <label class="form-label" for="form3Example3c">Xác nhận mật khẩu</label>
                                                    <input type="password" id="form3Example3c" class="form-control" required name="confirmPass"/>
                                                </div>
                                            </div>
                                            <div class="d-block mx-4 mb-3 mb-lg-4  text-danger"><b>${mess}</b></div>
                                            <div class="d-block mx-4 mb-3 mb-lg-4 text-center">
                                                <button class="btn btn-success btn-block px-5 w-100" type="submit">Xác nhận</button>
                                            </div>
                                            
                                            <div class="text-center pt-2">
                                                <a href="login">Trở về</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
