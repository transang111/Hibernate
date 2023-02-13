<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/View/header.jsp"%>

<title>Trang chủ</title>
</head>
<body>
	<!--header-->
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-inverse none_nav">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><img
						src='<c:url value="/resources/Image/icon_logo_shop.png" />' /></a>
				</div>
				<ul class="nav navbar-nav navbar-center">
					<li class="active"><a href="#">TRANG CHỦ</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">Sản Phẩm <span class="caret"></span></a>
						<ul class="dropdown-menu">
						     <c:forEach var="danhmuc" items="${listDanhMuc}">
							<li><a href="<c:url value="/sanpham/${danhmuc.getMadanhmuc()}/${danhmuc.getTendanhmuc()}"/>">${danhmuc.getTendanhmuc()}</a></li>
							<li role="separator" class="divider"></li>
							</c:forEach>
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
					<li><a href="#"><img
							src='<c:url value="/resources/Image/icon_giohang.png" />'
							height="35px" /></a></li>
				</ul>

			</div>
		</nav>
		<div class="event_header container wow animate__rubberBand" data-wow-duration="2s">
			<span>Ngày 17/10-23/10/2022</span><br /> <span
				style="font-size: 50px">Mua 1 Tặng 1</span><br />
			<button>XEM NGAY</button>
		</div>
	</div>
	<!-- end header -->
	<!-- in for-->
	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 wow animate__backInLeft" data-wow-duration="2s" >
				<img class="icon"
					src='<c:url value="/resources/Image/iconchatluong300x300-5293.png" />' />
				<br /> <span style="font-size: 32px; font-weight: 550;">CHẤT
					LƯỢNG</span><br /> <span>Chúng tôi cam kết sẽ mang đến cho các bạn
					chất lượng sản phẩm tốt nhất</span><br />
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow animate__backInDown" data-wow-duration="2s" data-wow-delay="1s">
				<img class="icon"
					src='<c:url value="/resources/Image/icontietkiem.jpg" />' /><br />
				<span style="font-size: 32px; font-weight: 550;">TIẾT KIỆM
					CHI PHÍ</span><br /> <span>Cam kết giá rẽ nhất việt nam giúp bạn
					tiết kiệm chi phí hơn 20% cho từng sản phẩm</span><br />
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow animate__backInUp"data-wow-duration="2s" data-wow-delay="2s">
				<img class="icon"
					src='<c:url value="/resources/Image/iconchatluong300x300-5293.png" />' /><br />
				<span style="font-size: 32px; font-weight: 550;">GIAO HÀNG</span><br />
			</div>
		</div>

	</div>
	<!--end infor-->

	<div id="title-sanpham" class="container">
		<span>SẢN PHẨM HOT</span>
		<div class="row">
		
		     <c:forEach var="sanpham" items="${listSanPham}">
		         <a href="chitiet/${sanpham.getMasanpham()}">
		             <div class="col-sm-6 col-md-3 sanpham wow animate__backInDown">
		                 <img alt="hinh"src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}" />'><br />
					     <span>${sanpham.getTensanpham()}</span><br /> 
					     <span class="gia">${sanpham.getGiatien()}</span>
			         </div>
			     </a>    
		     </c:forEach>
			<!-- end San pham -->
		</div>
	</div>
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow animate__rubberBand">
			    <p><span class="title-footer">THÔNG TIN SHOP</span></p><br/>
			    <span>Yami là một thương hiệu thời trang uy tính, luôn đặt chất lượng sản phẩm tốt nhất cho khách hàng</span>
 			</div>
			<div class="col-sm-4 col-md-4 wow animate__rubberBand">
			    <p><span class="title-footer">LIÊN HỆ</span></p><br/>
			    <span>67 Ông ích đường, cẩm lệ, Đà nẵng</span>
			    <span>tangsang11@gmail.com</span>
			    <span>0763644168</span>
			</div>
			<div class="col-sm-4 col-md-4 wow animate__rubberBand">
			   <p><span class="title-footer">GÓP Ý</span></p> <br/>
			   <form action="" method="post">
			    <input name="tennhanvien"class="material-textinput" style="margin-bottom: 8px;" type="text" placeholder="Email" /><br/>
			   <textarea name="tuoi" rows="4" cols="30" style="margin-bottom: 8px;" placeholder="Nội Dung"></textarea>
			   <button class="material-primary-button">ĐỒNG Ý</button>
			   </form>
			</div>
		</div>

	</div>

	<%@include file="/WEB-INF/View/footer.jsp"%>
</body>
</html>