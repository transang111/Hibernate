package Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import Entity.DanhMucSanPham;
import Entity.SanPham;
import Service.DanhMucService;
import Service.SanPhamService;


@Controller
@RequestMapping("/")
@SessionAttributes({"user","giohang"})
public class TrangChuController {
	@Autowired
    SanPhamService sanphamService;
    
	@Autowired
	DanhMucService danhMucSanPhamService;
	@GetMapping
	@Transactional
	public String  Defualt( String email,ModelMap modelmap,HttpSession httpSession) {
		
		List<DanhMucSanPham> listDanhMuc=danhMucSanPhamService.listDanhMuc();
		 
		if(httpSession.getAttribute("user")!=null) {
			 String chucaidau=email.substring(0, 1);
			 modelmap.addAttribute("chucaidau",chucaidau);
		}
		
	List<SanPham>listSanpham=sanphamService.LayDanhSachSanPhamLiMit(0);
	modelmap.addAttribute("listSanPham", listSanpham);
	modelmap.addAttribute("listDanhMuc", listDanhMuc);
		return "trangchu";
	}
	
}
