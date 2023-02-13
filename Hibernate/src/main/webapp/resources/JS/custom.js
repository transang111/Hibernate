	$(document).ready(function(){
	  $("#cot1").click(function(){
	     $(this).addClass("actived")
	  });

	$("#btndangnhap").click(function(){
		  var email=$("#email").val();
		  var matkhau=$("#matkhau").val();
	     $.ajax({
	    	 url:"http://localhost:8080/Hibernate/api/KiemTraDangNhap",
	    	 type:"get",
	    	 data:{
	    		 email:email,
	    		 matkhau:matkhau
	    	 },
	    	 success: function(value){
	    		 if(value=="true"){
	    			 duongDanHienTai=window.location.href
	    			 duongdan=duongDanHienTai.replace("dangnhap/","");
	    			 window.location=duongdan;
	    		 }else{
	    			 $("#ketqua").text("dang nhap that bai!")
	    		 }
	    	 }
	  })
	});
	$("#dangnhap").click(function(){
		$(this).addClass("actived");
		$("#dangky").removeClass("actived");
		$(".container-login-form1").show();
		$(".container-signup-form1").hide();
	})
	$("#dangky").click(function(){
		$(this).addClass("actived");
		$("#dangnhap").removeClass("actived");
		$(".container-login-form1").hide();
		$(".container-signup-form1").show();
	})
	
	$(".btn-giohang").click(function(){
		var machitiet=$(this).attr("data-machitiet");
		var mamau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		var tenmau=$(this).closest("tr").find(".mau").text();
		var tensize=$(this).closest("tr").find(".size").text();
		var soluong=$(this).closest("tr").find(".soluong").text();
		var tensp=$("#tensanpham").text();
		var masp=$("#tensanpham").attr("data-masp");
		var giatien=$("#giatien").attr("data-giatien");
		
		$.ajax({
	    	 url:"/Hibernate/api/ThemGioHang",
	    	 type:"get",
	    	 data:{
	    		 masp:masp,
	    		 masize:masize,
	    		 mamau:mamau,
	    		 tensp:tensp,
	    		 giatien:giatien,
	    		 tenmau:tenmau,
	    		 tensize:tensize,
	    		 soluong:1,
	    		 machitiet:machitiet,
	    	 },
	    	 success: function(value){
	    		 $("#giohang").find("div").addClass("circel-giohang");
	    		 $("#giohang").find("div").html("<span>"+value+"</span>");
	    	 }
	  })/*.done(function(){
		  $.ajax({
		    	 url:"/Hibernate/api/LaySoLuongSanPham",
		    	 type:"get",
		    	 success: function(value){
		    		 $("#giohang").find("div").addClass("circel-giohang");
		    		 $("#giohang").find("div").html("<span>"+value+"</span>");
		    	 }
		  })
	  });*/
	  
	  
	});
	Gantongtiengiohang();
	function Gantongtiengiohang(isEventChange){
		var tongtiensp = 0;
		$(".giatien").each(function(){
			var giatien=$(this).closest("tr").find(".giatien").attr("data-value");
			var soluong=$(this).closest("tr").find(".soluong-giohang").val();
			
			var tongtien=parseInt(giatien) * soluong;
			
			var format=tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
			tongtiensp=tongtiensp+tongtien;
			if(!isEventChange){
				 $(this).html(format);
			}
		    var formattongtien= tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		    $("#tongtien").html(formattongtien+"");
		})
	}
	
	
	$(".soluong-giohang").change(function(){
		var soluong=$(this).val();
	    var giatien=$(this).closest("tr").find(".giatien").attr("data-value");
	    
	    var tongtien=soluong * parseInt(giatien);
	    var format= tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
	    $(this).closest("tr").find(".giatien").html(format);
	    Gantongtiengiohang(true);
	    var mamau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		var masp= $(this).closest("tr").find(".tensp").attr("data-masp");
	    
	    $.ajax({
	    	 url:"/Hibernate/api/CapNhatGioHang",
	    	 type:"get",
	    	 data:{
	    		 masp:masp,
	    		 masize:masize,
	    		 mamau:mamau,
	    		 soluong:1,
	    	 },
	    	 success: function(value){
	    		 Gantongtiengiohang(true);
	    	 }
	  })
	    
	})
	$(".xoa-giohang").click(function(){
		var self=$(this);
		var mamau=$(this).closest("tr").find(".mau").attr("data-mamau")
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		var masp= $(this).closest("tr").find(".tensp").attr("data-masp");
		$.ajax({
	    	 url:"/Hibernate/api/XoaGioHang",
	    	 type:"get",
	    	 data:{
	    		 masp:masp,
	    		 masize:masize,
	    		 mamau:mamau,
	    	 },
	    	 success: function(value){
	    		
	    		 self.closest("tr").remove();
	    	 }
	  })
	})
	
	/*$(".soluong-giohang").blur(function(){
		var soluong=$(this).val();
		var mamau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		var masp= $(this).closest("tr").find(".tensp").attr("data-masp");
		$.ajax({
	    	 url:"/Hibernate/api/CapNhatGioHang",
	    	 type:"get",
	    	 data:{
	    		 masp:masp,
	    		 masize:masize,
	    		 mamau:mamau,
	    		 soluong:soluong,
	    	 },
	    	 success: function(value){
	    		 
	    	 }
	  })
	})*/
	
	$("body").on("click",".paging-items",function(){
		$(".paging-items").removeClass("active");
		$(this).addClass("active");
		var sotrang=$(this).text();
		var spbatdau=(sotrang-1)*5;
		
		$.ajax({
	    	 url:"/Hibernate/api/LaySanPhamLimit",
	    	 type:"get",
	    	 data:{
	    		 spbatdau:spbatdau,
	    	 },
	    	 success: function(value){
	    		var tbodysanpham= $("#table-sanpham").find("tbody");
	    		tbodysanpham.empty();
	    		tbodysanpham.append(value);
	    	 }
	  })
	})
	
	$("#checkall").change(function(){
		if(this.checked){
			$("#table-sanpham input").each(function(){
				$(this).attr("checked","checked");
			})
		}else{
		}
	})
	
	$("#xoa-sanpham").click(function(){
		$("#table-sanpham >tbody input:checked").each(function(){
			var masanpham=$(this).val();
			$(this).closest("tr").remove();
		})
	})
	var files=[];
	$("#hinhanh").change(function(event){
		files=event.target.files;
		forms= new FormData();
		forms.append("file",files[0]);
		$.ajax({
	    	 url:"/Hibernate/api/Uploadfile",
	    	 type:"post",
	    	 data :forms,
	    	 contentType:false,
	    	 processData:false,
	    	 enctype:"multipart/form-data",
	    	 success: function(value){
	    	 }
	  })
		
	})
	
})
