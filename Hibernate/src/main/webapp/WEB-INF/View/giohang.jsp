<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/View/header.jsp"%>

<title>Giỏ Hàng</title>
</head>
<body>
	<!--header-->
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-inverse none_nav">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><img
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
					  <a id="giohang" href="#">
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
	       <div class="col-sm-12 col-md-6">
	          <h3><b>Danh Sách Sản Phẩm Trong Giỏ Hàng</b></h3>
	             <table class="table">
	                <thead>
	                   <tr>
	                    <th>Tên Sản Phẩm</th>
	                    <th>Màu Sản Phẩm</th>
	                    <th>Size</th>
	                    <th>Số Lượng</th>
	                    <th>Giá Tiền</th>
	                    
	                   </tr>
	                </thead>
	                <tbody>
	                      <c:forEach var="giohang" items="${listGioHang}">
	                          <tr data-machitiet="${giohang.getMachitiet()}">
	                            <td class="tensp" data-masp="${giohang.getMasp()}">${giohang.getTensp()}</td>  
	                            <td class="mau" data-mamau="${giohang.getMamau()}">${giohang.getTenmau()}</td>
								<td class="size" data-masize="${giohang.getMasize()}" ><span contenteditable="true">${giohang.getTensize()}</span></td>
								<td class="soluong"><input class="soluong-giohang" min="1" type="number" value="${giohang.getSoluong()}"></td>
								<td class="giatien" data-value="${giohang.getGiatien()}">${giohang.getGiatien()}</td>
								<td><button type="button" class="xoa-giohang btn btn-warning">Xóa</button></td>
	                          </tr>
	                     </c:forEach>
	                </tbody>
	              </table>
	              <h4>Tổng Tiền:<span id="tongtien" style="color: red"></span> VNĐ</h4>
	           </div>
	           <div class="col-sm-12 col-md-6">
	                   <h3><b>Thông Tin Người Nhận/Người Mua</b></h3>
	           <div class="form-group">
				  <form action="" method="post">
				           <label for="tenkhachhang">Tên Người Mua/Nhận</label>
			               <input id="tenkhachhang"  class="form-control" name="tenkhachhang"> <br>
			               
			               <label for="sodt">Điện Thoại Liên Lạc</label>
			               <input id="sodt"  class="form-control" name="sodt">
			               <div class="form-check">
							  <input type="radio" class="form-check-input" id="radio1" name="hinhthucgiaohang" value="Giao Hàng Tận Nơi" checked> Giao Hàng Tận Nơi
							  <label class="form-check-label" for="radio1"></label>
							</div>
							<div class="form-check">
							  <input type="radio" class="form-check-input" id="radio2" name="hinhthucgiaohang" value="Nhận Hàng Tại cửa Hàng"> Nhận Hàng Tại cửa Hàng
							  <label class="form-check-label" for="radio2"></label>
							</div> <br>
			               <label for="diachigiaohang">Địa chỉ nhận hàng</label>
			               <input id="diachigiaohang"  class="form-control" name="diachigiaohang"> <br>
			               
			               <label for="ghichu">Ghi Chú</label>
						  <textarea id="ghichu" class="form-control"  rows="5" name="ghichu"></textarea><br>
						  <input type="submit" class="btn btn-primary" value="Đặt Hàng" />
				  </form>
	           </div>
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