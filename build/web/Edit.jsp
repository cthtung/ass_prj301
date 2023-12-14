
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sản phẩm</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editPro" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Sửa sản phẩm</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><a href="addPro">&times;</a></button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${Pro.getId()}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Tên</label>
                                    <input value="${Pro.getName()}" name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Ảnh</label>
                                    <input value="${Pro.getImage()}" name="image" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Giá</label>
                                    <input value="${Pro.getPrice()}" name="price" type="text"  pattern="^\d+\.*\d*$" title="Please Enter Double Value!" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Tiêu đề</label>
                                    <textarea name="title" class="form-control" required>${Pro.getTitle()}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Giới thiệu</label>
                                    <textarea name="description" class="form-control" required>${Pro.getDescription()}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Phân loại</label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listC}" var="o">
                                            <option ${(Pro.getCateID() == o.cid)?"selected":""} value="${o.cid}">${o.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>

