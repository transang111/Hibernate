<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/View/header.jsp"%>

<title>Đăng Nhập</title>
</head>
<body id="body-login">

	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
			</div>
			<div id="container-login-right">
				<div class="container-login-form" id="container-login-right">
					<nav class="navbar navbar-inverse none_nav">
						<div>
							<span
								style="color: #3300FF; cursor: pointer; background-color: #00FF00; text-shadow: 2px 2px #33FF33"><a
								href="../">Trang Chủ</a> </span> <a id="link"
								href="https://www.facebook.com/"><img
							src='<c:url value="/resources/Image/icon_giohang.png" />'
							height="35px" /></a> <a id="link"
								href="https://www.google.com/"><img
							src='<c:url value="/resources/Image/icon_giohang.png" />'
							height="35px" /></a>
						</div>
					</nav>
					<h1 style="color: #3300FF">Tài khoản Thời Trang</h1><br/>
					 <div id="header-top-right" class="header-login">
					  <span class="actived" id="dangnhap">Đăng Nhập</span>/<span id="dangky">Đăng Ký</span>
					 </div>
								
					<!-- <form action="" method="post"> -->
					<div id="footer" class="container-fluid">
				<div class="row">
					<div class="col-sm-4 col-md-4 wow animate__rubberBand">
					   <div class="container-login-form1">
					   <form action="" method="get">
					    <input id="email"name="email" class="material-textinput" style="margin-bottom: 8px;" type="text" placeholder="Email" /><br/>
					   <input  id="matkhau"name="matkhau" class="material-textinput" style="margin-bottom: 8px;" type="password" placeholder="Mật Khẩu"/>
					   <input id="btndangnhap"class="material-primary-button" type="submit" value="Đăng Nhập">
					    </form>
					   </div>
					   <div class="container-signup-form1">
					     <form action="" method="post">
					       <input id="email"name="email" class="material-textinput" style="margin-bottom: 8px;" type="text" placeholder="Email" /><br/>
						   <input  id="matkhau"name="matkhau" class="material-textinput" style="margin-bottom: 8px;" type="password" placeholder="Mật Khẩu"/>
						   <input  id="nhaplaimatkhau"name="nhaplaimatkhau" class="material-textinput" style="margin-bottom: 8px;" type="password" placeholder="Nhập Lại Mật Khẩu"/>
						   <input id=""class="material-primary-button" type="submit" value="Đăng Ký">
					     </form>
					   </div>
					   
					<span id="ketqua"></span>
					<span>${kiemtradangnhap}</span>
					   
					</div>
				</div>
			</div>
					<!-- </form> -->
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/View/footer.jsp"%>
</body>
</html>