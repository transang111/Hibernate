	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/View/header.jsp"%>

<title>Chi Tiết</title>
</head>
<body>
	<!--header-->
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-inverse none_nav">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href=""><img
						src='<c:url value="/resources/Image/icon_logo_shop.png" />' /></a>
				</div>
				<ul class="nav navbar-nav navbar-center">
					<li class="active"><a href="#">TRANG CHỦ</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Page 1-1</a></li>
							<li><a href="#">Page 1-2</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul></li>
					<li><a href="#">DỊCH VỤ</a></li>
					<li><a href="#">LIÊN HỆ</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${chucaidau !=null}">
							<li><a href="dangnhap/"><span class="circke-avatar">${chucaidau}</span></a></li>
						</c:when>

						<c:otherwise>
							<li><a href="dangnhap/"><span>Đăng Nhập</span></a></li>
						</c:otherwise>
					</c:choose>
					<li>
					  <a id="giohang" href="/Hibernate/giohang">
					    <img src='<c:url value="/resources/Image/icon_giohang.png" />'height="28px" />
					    <c:if test="${soluongsanphamgiohang>0}">
					    <div class="circel-giohang"><span>${soluongsanphamgiohang}</span></div>
					    </c:if>
					    <c:if test="${soluongsanphamgiohang <= 0 || soluongsanphamgiohang == null}">
					    <div><span>${soluongsanphamgiohang}</span></div>
					    </c:if>
					   </a>
				   </li>
				</ul>

			</div>
		</nav>
	</div>
	<!-- end header -->
	<div class="container">
		<div class="row">
			<div class="col-sm-2 col-md-2">
				<h3>Danh Mục</h3>
				<ul class="mymenu">
				   <c:forEach var="danhmuc" items="${listDanhMuc}">
					<li><a href="#">${danhmuc.getTendanhmuc()}</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<img style="margin-top: 30px"
							src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}"/>'>
					</div>
					<div class="col-sm-8 col-md-8">
						<h3 id="tensanpham" data-masp="${sanpham.getMasanpham()}">${sanpham.getTensanpham()}</h3>
						<h4 id="giatien" data-giatien="${sanpham.getGiatien()}"  style="color: red;">${sanpham.getGiatien()}VND</h4>
						<table class="table">
							<thead>
								<tr>
									<th>Màu Sản Phẩm</th>
									<th>Size</th>
									<th>Số Lượng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="chitietsanpham" items="${sanpham.getChiTietSanPham()}">
									<tr>
										<td class="mau" data-mamau="${chitietsanpham.getMausanpham().getMamau()}">${chitietsanpham.getMausanpham().getTenmau()}</td>
										<td class="size" data-masize="${chitietsanpham.getSizesanpham().getMasize()}" >${chitietsanpham.getSizesanpham().getSize()}</td>
										<td class="soluong">${chitietsanpham.getSoluong()}</td>
										<td><button data-machitiet="${chitietsanpham.getMachitietsanpham()}" type="button" class="btn btn-danger btn-giohang">Giỏ
												Hàng</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-2 col-md-2">
				<span> ${sanpham.getMota()} </span>
			</div>

		</div>
	</div>

	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow animate__rubberBand">
				<p>
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<br /> <span>Yami là một thương hiệu thời trang uy tính, luôn
					đặt chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			<div class="col-sm-4 col-md-4 wow animate__rubberBand">
				<p>
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<br /> <span>67 Ông ích đường, cẩm lệ, Đà nẵng</span> <span>tangsang11@gmail.com</span>
				<span>0763644168</span>
			</div>
			<div class="col-sm-4 col-md-4 wow animate__rubberBand">
				<p>
					<span class="title-footer">GÓP Ý</span>
				</p>
				<br />
				<form action="" method="post">
					<input name="tennhanvien" class="material-textinput"
						style="margin-bottom: 8px;" type="text" placeholder="Email" /><br />
					<textarea name="tuoi" rows="4" cols="30"
						style="margin-bottom: 8px;" placeholder="Nội Dung"></textarea>
					<button class="material-primary-button">ĐỒNG Ý</button>
				</form>
			</div>
		</div>

	</div>

	<%@include file="/WEB-INF/View/footer.jsp"%>
</body>
</html>