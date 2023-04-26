<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quản lý sản phẩm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        .modal-open {
            overflow: scroll;
        }
    </style>
</head>
<body>
<jsp:include page="template/header.jsp"></jsp:include>
<jsp:include page="template/sidebar.jsp"></jsp:include>

<div class="col-md-9 animated bounce">
    <h3 class="page-header">Quản lý Sản Phẩm</h3>

    <div class="form-group form-inline">
        <div>
            <label for="sel1">THÊM MỚI SẢN PHẨM (THEO DANH MỤC): </label>
        </div>
        <select id="danhMucDropdown" class="form-control">
            <c:forEach var="danhMuc" items="${listDanhMuc}">
                <option value="${danhMuc.id }">${danhMuc.tenDanhMuc }</option>
            </c:forEach>
        </select>
    </div>

    <hr>

    <form class="form-inline" id="searchForm" name="searchObject">
        <div class="form-group">
            <select class="form-control" name="danhMucId" id="danhMuc">
                <c:forEach var="danhMuc" items="${listDanhMuc }">
                    <option value="${danhMuc.id}">${danhMuc.tenDanhMuc}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" name="hangSXId" id="hangSanXuat">
                <option value="">Tất cả nhà sản xuất</option>
                <c:forEach var="nhanHieu" items="${listNhanHieu }">
                    <option value="${nhanHieu.id}">${nhanHieu.tenHangSanXuat}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" name="donGia" id="price">
                <option value="">Tất cả giá</option>
                <option value="duoi-5-chuc">Dưới 50.000đ</option>
                <option value="5-chuc-den-1-tram">50.000->100.000đ</option>
                <option value="1-tram-den-2-tram">100.000->200.000đ</option>
                <option value="2-tram-den-3-tram">200.000->300.000đ</option>
                <option value="tren-3-tram">Trên 300.000đ</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" name="sapXepTheoGia">
                <option value="asc">Sắp xếp theo giá tăng dần</option>
                <option value="desc">Sắp xếp theo giá giảm dần</option>
            </select>
        </div>

        &nbsp;&nbsp;
        <button type="button" class="btn btn-primary" id="btnDuyetSanPham">Duyệt
            sản phẩm
        </button>
    </form>

    <hr/>
    <br>
    <div class="form-group form-inline"
         style="float: right; margin-right: 10px; top: -33px; position: relative;">
        <input class="form-control" type="text" id="searchById"
               placeholder="Nhập mã Book để tìm nhanh">
            <span class="glyphicon glyphicon-search" aria-hidden="true" style="left: -30px; top: 4px;"></span>
    </div>
    <hr/>

    <table class="table table-hover sanPhamTable"
           style="text-align: center;">
        <thead>
            <tr>
                <th>Hình ảnh</th>
                <th>Tên SP</th>
                <th>Danh Mục</th>
                <th>Nhà sản xuất</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
            </tr>
        </thead>
        <tbody>
        </tbody>

    </table>

    <ul class="pagination">
    </ul>
</div>

<div class="row col-md-6">
    <form id="bookForm" class="bookForm">
        <div class="modal fade bookModal" tabindex="-1" role="dialog"
             data-keyboard="false" data-backdrop="static">
            <div class="modal-dialog modal-lg" role="document"
                 style="width: 60%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thêm mới/ Cập
                            nhật Book</h5>
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div>
                                <input type="hidden" class="form-control" name="danhMucId"
                                       id="idDanhMucBook">
                            </div>
                            <div>
                                <input type="hidden" class="form-control" name="id"
                                       id="idSanPhamBook" readonly>
                            </div>
                            <div class="form-group col-md-7">
                                <label for="inputPassword4">Tên sản phẩm</label> <input
                                    type="text" class="form-control" name="tenSanPham">
                            </div>
                            <div class="form-group col-md-5">
                                <label for="inputPassword4">Đơn giá</label> <input
                                    type="number" class="form-control" name="donGia" min="0"
                                    value="0" id="test">
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="inputState">Nhà Sản Xuất</label> <select
                                    name="nhaSXId" class="form-control" id="nhaSXId">
                                <c:forEach var="nhanHieu" items="${listNhanHieu }">
                                    <option value="${nhanHieu.id}">${nhanHieu.tenHangSanXuat}</option>
                                </c:forEach>
                            </select>
                            </div>

                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="inputPassword4">Mô tả chung</label>
                                <textarea class="form-control" name="thongTinChung"
                                          placeholder="" rows="2" required="required"></textarea>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="inputPassword4">Số lượng</label> <input
                                    type="number" class="form-control" name="donViKho" min="0"
                                    required="required" value="0" id="test2">
                            </div>
                        </div>
                        <div>
                            <label for="inputEmail4">Hình ảnh</label>
                            <input type="file"
                                   class="form-control" id="inputEmail4"
                                   name="hinhAnh">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">Hủy
                        </button>
                        <input class="btn btn-primary" id="btnSubmit" type="button"
                               value="Xác nhận"/>
                    </div>

                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
    </form>
</div>


<div class="row col-md-6">
    <form class="otherForm" id="otherForm">
        <div class="modal fade otherModal" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document"
                 style="width: 60%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div>
                                <input type="hidden" class="form-control" name='danhMucId'
                                       id="idDanhMucKhac">
                            </div>
                            <div>
                                <input type="hidden" class="form-control" name="id"
                                       id="idSanPhamKhac" readonly="true">
                            </div>
                            <div class="form-group col-md-12">
                                <label for="inputPassword4">Tên sản phẩm</label> <input
                                    type="text" class="form-control" name="tenSanPham">
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputState">Nhà Sản Xuất</label> <select
                                    name="nhaSXId" id="nhaSXIdKhac" class="form-control">
                                <c:forEach var="nhanHieu" items="${listNhanHieu }">
                                    <option value="${nhanHieu.id }">${nhanHieu.tenHangSanXuat}
                                    </option>
                                </c:forEach>
                            </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputPassword4">Đơn giá</label> <input
                                    type="number" class="form-control" name="donGia" min="0"
                                    value="0" id="donGiaKhac">
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="inputPassword4">Mô tả chung</label>
                                <textarea class="form-control" id="inputPassword4"
                                          placeholder="" rows="2" name="thongTinChung"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputPassword4">Số lượng</label> <input
                                    type="number" class="form-control" name="donViKho" min="0"
                                    value="0">
                            </div>
                        </div>
                        <div>
                            <label for="inputEmail4">Hình ảnh</label> <input type="file"
                                                                             class="form-control" name="hinhAnh">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">Hủy
                        </button>
                        <button class="btn btn-primary" id="btnSubmit" type="submit">Xác
                            nhận
                        </button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
    </form>
</div>

<div class="row col-md-10">
    <form class="chiTietForm">
        <div class="modal fade" id="chiTietModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog " role="document" style="width: 60%">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="title" style="text-align: center; font-weight: bolder;">Chi tiết sản phẩm</h3>
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="card">
                            <div class="container-fliud">
                                <div class="wrapper row">
                                    <div class="preview col-md-6">

                                        <div class="preview-pic tab-content">
                                            <div class="tab-pane active" id="pic-1">
                                                <img style="width: 350px; height: 350px" class="hinhAnh"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="details col-md-6" style="font-size: 16px">
                                        <p class="maSanPham"></p>
                                        <p class="tenSanPham"></p>
                                        <p class="hangSangXuat"></p>
                                        <p class="thongTinChung"></p>
                                        <p class="donGia"></p>
                                        <p class="donViKho"></p>
                                        <p class="donViBan"></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-dismiss="modal">Đóng
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</div>


<jsp:include page="template/footer.jsp"></jsp:include>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
<script src="<c:url value='/js/sanPhamAjax.js'/>"></script>
</body>
</html>